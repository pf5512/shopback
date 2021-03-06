package com.zq.shop.web.bean;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table zq_category
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class ProductCategory {
    /**
     * Database Column Remarks:
     *   类别Id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zq_category.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   父类别id当id=0时说明是根节点,一级类别
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zq_category.parent_id
     *
     * @mbg.generated
     */
    private Integer parentId;

    /**
     * Database Column Remarks:
     *   类别名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zq_category.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     * Database Column Remarks:
     *   类别状态1-正常,2-已废弃
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zq_category.status
     *
     * @mbg.generated
     */
    private Boolean status;

    /**
     * Database Column Remarks:
     *   排序编号,同类展示顺序,数值相等则自然排序
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zq_category.sort_order
     *
     * @mbg.generated
     */
    private Integer sortOrder;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zq_category.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   更新时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zq_category.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zq_category.id
     *
     * @return the value of zq_category.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zq_category.id
     *
     * @param id the value for zq_category.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zq_category.parent_id
     *
     * @return the value of zq_category.parent_id
     *
     * @mbg.generated
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zq_category.parent_id
     *
     * @param parentId the value for zq_category.parent_id
     *
     * @mbg.generated
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zq_category.name
     *
     * @return the value of zq_category.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zq_category.name
     *
     * @param name the value for zq_category.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zq_category.status
     *
     * @return the value of zq_category.status
     *
     * @mbg.generated
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zq_category.status
     *
     * @param status the value for zq_category.status
     *
     * @mbg.generated
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zq_category.sort_order
     *
     * @return the value of zq_category.sort_order
     *
     * @mbg.generated
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zq_category.sort_order
     *
     * @param sortOrder the value for zq_category.sort_order
     *
     * @mbg.generated
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zq_category.create_time
     *
     * @return the value of zq_category.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zq_category.create_time
     *
     * @param createTime the value for zq_category.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zq_category.update_time
     *
     * @return the value of zq_category.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zq_category.update_time
     *
     * @param updateTime the value for zq_category.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}