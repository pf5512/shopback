package com.zq.shop.web.bean;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table zq_shipping
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class Shipping {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zq_shipping.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   用户id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zq_shipping.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * Database Column Remarks:
     *   收货姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zq_shipping.receiver_name
     *
     * @mbg.generated
     */
    private String receiverName;

    /**
     * Database Column Remarks:
     *   收货固定电话
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zq_shipping.receiver_phone
     *
     * @mbg.generated
     */
    private String receiverPhone;

    /**
     * Database Column Remarks:
     *   收货移动电话
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zq_shipping.receiver_mobile
     *
     * @mbg.generated
     */
    private String receiverMobile;

    /**
     * Database Column Remarks:
     *   省份
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zq_shipping.receiver_province
     *
     * @mbg.generated
     */
    private String receiverProvince;

    /**
     * Database Column Remarks:
     *   城市
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zq_shipping.receiver_city
     *
     * @mbg.generated
     */
    private String receiverCity;

    /**
     * Database Column Remarks:
     *   区/县
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zq_shipping.receiver_district
     *
     * @mbg.generated
     */
    private String receiverDistrict;

    /**
     * Database Column Remarks:
     *   详细地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zq_shipping.receiver_address
     *
     * @mbg.generated
     */
    private String receiverAddress;

    /**
     * Database Column Remarks:
     *   邮编
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zq_shipping.receiver_zip
     *
     * @mbg.generated
     */
    private String receiverZip;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zq_shipping.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zq_shipping.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zq_shipping.id
     *
     * @return the value of zq_shipping.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zq_shipping.id
     *
     * @param id the value for zq_shipping.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zq_shipping.user_id
     *
     * @return the value of zq_shipping.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zq_shipping.user_id
     *
     * @param userId the value for zq_shipping.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zq_shipping.receiver_name
     *
     * @return the value of zq_shipping.receiver_name
     *
     * @mbg.generated
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zq_shipping.receiver_name
     *
     * @param receiverName the value for zq_shipping.receiver_name
     *
     * @mbg.generated
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zq_shipping.receiver_phone
     *
     * @return the value of zq_shipping.receiver_phone
     *
     * @mbg.generated
     */
    public String getReceiverPhone() {
        return receiverPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zq_shipping.receiver_phone
     *
     * @param receiverPhone the value for zq_shipping.receiver_phone
     *
     * @mbg.generated
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zq_shipping.receiver_mobile
     *
     * @return the value of zq_shipping.receiver_mobile
     *
     * @mbg.generated
     */
    public String getReceiverMobile() {
        return receiverMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zq_shipping.receiver_mobile
     *
     * @param receiverMobile the value for zq_shipping.receiver_mobile
     *
     * @mbg.generated
     */
    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zq_shipping.receiver_province
     *
     * @return the value of zq_shipping.receiver_province
     *
     * @mbg.generated
     */
    public String getReceiverProvince() {
        return receiverProvince;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zq_shipping.receiver_province
     *
     * @param receiverProvince the value for zq_shipping.receiver_province
     *
     * @mbg.generated
     */
    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zq_shipping.receiver_city
     *
     * @return the value of zq_shipping.receiver_city
     *
     * @mbg.generated
     */
    public String getReceiverCity() {
        return receiverCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zq_shipping.receiver_city
     *
     * @param receiverCity the value for zq_shipping.receiver_city
     *
     * @mbg.generated
     */
    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zq_shipping.receiver_district
     *
     * @return the value of zq_shipping.receiver_district
     *
     * @mbg.generated
     */
    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zq_shipping.receiver_district
     *
     * @param receiverDistrict the value for zq_shipping.receiver_district
     *
     * @mbg.generated
     */
    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zq_shipping.receiver_address
     *
     * @return the value of zq_shipping.receiver_address
     *
     * @mbg.generated
     */
    public String getReceiverAddress() {
        return receiverAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zq_shipping.receiver_address
     *
     * @param receiverAddress the value for zq_shipping.receiver_address
     *
     * @mbg.generated
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zq_shipping.receiver_zip
     *
     * @return the value of zq_shipping.receiver_zip
     *
     * @mbg.generated
     */
    public String getReceiverZip() {
        return receiverZip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zq_shipping.receiver_zip
     *
     * @param receiverZip the value for zq_shipping.receiver_zip
     *
     * @mbg.generated
     */
    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zq_shipping.create_time
     *
     * @return the value of zq_shipping.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zq_shipping.create_time
     *
     * @param createTime the value for zq_shipping.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zq_shipping.update_time
     *
     * @return the value of zq_shipping.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zq_shipping.update_time
     *
     * @param updateTime the value for zq_shipping.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}