package com.zq.shop.web.mappers;

import com.zq.shop.web.bean.ShopUser;
import org.apache.ibatis.annotations.Param;

public interface ShopUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zq_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zq_user
     *
     * @mbg.generated
     */
    int insert(ShopUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zq_user
     *
     * @mbg.generated
     */
    int insertSelective(ShopUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zq_user
     *
     * @mbg.generated
     */
    ShopUser selectByPrimaryKey(Integer uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zq_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ShopUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zq_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ShopUser record);

    int updatePasswordByUid(@Param("updatedPassword") String updatedPassword, @Param("uid") Integer uid);

    int updateImageByUid(@Param("updatedImage") String updatedImage, @Param("uid") Integer uid);

    ShopUser findOneByPhone(@Param("phone") String phone);

    ShopUser findOneByEmail(@Param("email") String email);

}