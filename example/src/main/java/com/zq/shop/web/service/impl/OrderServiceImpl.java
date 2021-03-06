package com.zq.shop.web.service.impl;

import com.google.common.collect.Lists;
import com.zq.core.restful.ServerResponse;
import com.zq.shop.utils.BigDecimalUtil;
import com.zq.shop.web.bean.Cart;
import com.zq.shop.web.bean.Order;
import com.zq.shop.web.bean.OrderItem;
import com.zq.shop.web.bean.Product;
import com.zq.shop.web.common.Const;
import com.zq.shop.web.mappers.*;
import com.zq.shop.web.service.IOrderService;
import com.zq.shop.web.vo.OrderVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author 张迁-zhangqian
 * @Data 2018/4/22 下午7:59
 * @Package com.zq.shop.web.service.impl
 **/


@Service("iOrderService")
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ShippingMapper shippingMapper;

    @Autowired
    private IDMapper idMapper;

    @Transactional//开启事务  防止插入删除后
    public ServerResponse createOrder(Integer userId, Integer shippingId) {

        //从购物车中获取数据
        List<Cart> cartList = cartMapper.findByUserIdAndcheckedBetweenOrEqualTo(userId, Const.Cart.CHECKED, Const.Cart.CHECKED);

        //计算这个订单的总价
        ServerResponse<List<OrderItem>> serverResponse = this.getCartOrderItem(userId, cartList);
        if (!serverResponse.isSuccess()) {
            return serverResponse;
        }
        List<OrderItem> orderItemList = serverResponse.getData();
        BigDecimal payment = this.getOrderTotalPrice(orderItemList);

        //生成订单
        Order order = this.assembleOrder(userId, shippingId, payment);
        if (order == null) {
            return ServerResponse.createByErrorMessage("生成订单错误");
        }
        if (CollectionUtils.isEmpty(orderItemList)) {
            return ServerResponse.createByErrorMessage("购物车为空");
        }
        for (OrderItem orderItem : orderItemList) {
            orderItem.setOrderNo(order.getOrderNo());
        }

        //mybatis 批量插入
        orderItemMapper.batchInsert(orderItemList);

        //生成成功,我们要减少我们产品的库存
        reduceProductStock(orderItemList);
        //清空一下购物车
        this.cleanCart(cartList);

        //返回给前端数据
        OrderVo orderVo = assembleOrderVo(order, orderItemList);
        return ServerResponse.createBySuccess(orderVo);
    }

    public ServerResponse<String> cancel(Integer userId, Long orderNo) {
        Order order = orderMapper.findOneByUserIdAndOrderNo(userId, orderNo);
        if (order == null) {
            return ServerResponse.createByErrorMessage("该用户此订单不存在");
        }
        if (order.getStatus() != Const.OrderStatus.NO_PAY) {
            return ServerResponse.createByErrorMessage("已付款,无法取消订单");
        }
        Order updateOrder = new Order();
        updateOrder.setId(order.getId());
        updateOrder.setStatus(Const.OrderStatus.CANCELED);
        int row = orderMapper.updateByPrimaryKeySelective(updateOrder);
        if (row > 0) {
            return ServerResponse.createBySuccess("取消订单成功");
        }
        return ServerResponse.createByErrorMessage("取消订单失败");
    }

    public ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo) {
        Order order = orderMapper.findOneByUserIdAndOrderNo(userId, orderNo);
        if (order != null) {
            List<OrderItem> orderItemList = orderItemMapper.findByUserIdAndOrderNo(userId, orderNo);
            OrderVo orderVo = assembleOrderVo(order, orderItemList);
            return ServerResponse.createBySuccess(orderVo);
        }
        return ServerResponse.createByErrorMessage("没有找到该订单");
    }


    public ServerResponse<List<Order>> getOrderList(Integer userId, int pageNum, int pageSize) {
        List<Order> orderList = orderMapper.findByUserId(userId);
        return ServerResponse.createBySuccess(orderList);
    }

    @Override
    public ServerResponse getOrderCheckedProductList(Integer uid, int i, int i1) {
        List<Cart> cartList = cartMapper.findByUserIdAndcheckedBetweenOrEqualTo(uid, Const.Cart.CHECKED, Const.Cart.CHECKED);
        return ServerResponse.createBySuccess(cartList);
    }

    @Override
    public ServerResponse<List<OrderVo>> manageList(int pageNum, int pageSize) {
        List<OrderVo> orderVos = Lists.newArrayList();
        List<Order> orders = orderMapper.find();

        for (Order order : orders) {

            orderVos.add(assembleOrderVo(order, orderItemMapper.findByOrderNo(order.getOrderNo())));
        }


        return ServerResponse.createBySuccess(orderVos);
    }

    @Override
    public ServerResponse<OrderVo> manageDetail(Long orderNo) {
        return ServerResponse.createBySuccess(assembleOrderVo(orderMapper.findOneByOrderNo(orderNo),
                orderItemMapper.findByOrderNo(orderNo)));
    }

    @Override
    public ServerResponse<String> manageSendGoods(Long orderNo) {

        Order order = orderMapper.findOneByOrderNo(orderNo);
        if (order != null) {
            if (order.getStatus() == Const.OrderStatus.PAID) {
                order.setStatus(Const.OrderStatus.SHIPPED);
                order.setSendTime(new Date());
                orderMapper.updateByPrimaryKeySelective(order);
                return ServerResponse.createBySuccess("发货成功");
            }
        }
        return null;
    }


    /**
     * 组成完成的订单信息
     *
     * @param order
     * @param orderItemList
     * @return
     */
    private OrderVo assembleOrderVo(Order order, List<OrderItem> orderItemList) {
        OrderVo orderVo = new OrderVo();
        orderVo.setOrder(order);
        orderVo.setOrderItems(orderItemList);
        orderVo.setShipping(shippingMapper.selectByPrimaryKey(order.getShippingId()));
        return orderVo;
    }

    /**
     * 清空加进订单里面的商品
     *
     * @param cartList
     */
    private void cleanCart(List<Cart> cartList) {
        for (Cart cart : cartList) {
            cartMapper.deleteByPrimaryKey(cart.getId());
        }
    }

    /**
     * 减少商品的存货量
     *
     * @param orderItemList
     */
    private void reduceProductStock(List<OrderItem> orderItemList) {
        for (OrderItem orderItem : orderItemList) {
            Product product = productMapper.selectByPrimaryKey(orderItem.getProductId());
            product.setStock(product.getStock() - orderItem.getQuantity());
            productMapper.updateByPrimaryKeySelective(product);
        }
    }

    /**
     * 生成一个完整的订单
     *
     * @param userId
     * @param shippingId
     * @param payment
     * @return
     */
    private Order assembleOrder(Integer userId, Integer shippingId, BigDecimal payment) {
        Order order = new Order();
        long orderNo = this.generateOrderNo();
        order.setOrderNo(orderNo);
        order.setStatus(Const.OrderStatus.NO_PAY);
        order.setPostage(0);
        order.setPaymentType(Const.PaymentType.ON_Line);
        order.setPayment(payment);

        order.setUserId(userId);
        order.setShippingId(shippingId);
        //发货时间等等
        //付款时间等等
        int rowCount = orderMapper.insert(order);
        if (rowCount > 0) {
            return order;
        }
        return null;
    }

    /**
     * 生成订单号
     *
     * @return
     */
    private long generateOrderNo() {

        long currentTime = System.currentTimeMillis();
        return currentTime + new Random().nextInt(100);
    }

    /**
     * 获取 订单orderitem 综合价钱
     *
     * @param orderItemList
     * @return
     */
    private BigDecimal getOrderTotalPrice(List<OrderItem> orderItemList) {
        BigDecimal payment = new BigDecimal("0");
        for (OrderItem orderItem : orderItemList) {
            payment = BigDecimalUtil.add(payment.doubleValue(), orderItem.getTotalPrice().doubleValue());
        }
        return payment;
    }

    /**
     * 获取OrderItem列表
     *
     * @param userId
     * @param cartList
     * @return
     */
    private ServerResponse<List<OrderItem>> getCartOrderItem(Integer userId, List<Cart> cartList) {
        List<OrderItem> orderItemList = Lists.newArrayList();
        if (CollectionUtils.isEmpty(cartList)) {
            return ServerResponse.createByErrorMessage("购物车为空");
        }

        //校验购物车的数据,包括产品的状态和数量
        for (Cart cartItem : cartList) {
            OrderItem orderItem = new OrderItem();
            Product product = productMapper.selectByPrimaryKey(cartItem.getProductId());
            if (Const.ProductStatus.ON_SALE != product.getStatus()) {
                return ServerResponse.createByErrorMessage("产品" + product.getName() + "不是在线售卖状态");
            }

            //校验库存
            if (cartItem.getQuantity() > product.getStock()) {
                return ServerResponse.createByErrorMessage("产品" + product.getName() + "库存不足");
            }

            orderItem.setUserId(userId);
            orderItem.setProductId(product.getId());
            orderItem.setProductName(product.getName());
            orderItem.setProductImage(product.getMainImage());
            orderItem.setCurrentUnitPrice(product.getPrice());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setTotalPrice(BigDecimalUtil.mul(product.getPrice().doubleValue(), cartItem.getQuantity()));
            orderItemList.add(orderItem);
        }
        return ServerResponse.createBySuccess(orderItemList);
    }
}
