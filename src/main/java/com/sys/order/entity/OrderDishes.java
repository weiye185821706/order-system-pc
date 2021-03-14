package com.sys.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sys.order.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * <p>
 * 订单和菜品关联表
 * </p>
 *
 * @author yewei
 * @since 2021-03-11
 */
@TableName("ORDER_DISHES")
public class OrderDishes extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 订单id
     */
    @TableField("ORDER_ID")
    private Long orderId;

    /**
     * 菜品id
     */
    @TableField("DISHES_ID")
    private Long dishesId;

    /**
     * 菜品状态
     */
    @TableField("STATUS")
    private String status;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getDishesId() {
        return dishesId;
    }

    public void setDishesId(Long dishesId) {
        this.dishesId = dishesId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
