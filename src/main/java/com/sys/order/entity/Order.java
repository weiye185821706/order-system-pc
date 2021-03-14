package com.sys.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sys.order.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@TableName("ORDER")
@ApiModel(value="Order对象", description="订单表")
public class Order extends BaseEntity {

    private static final long serialVersionUID=1L;

    @TableField("STATUS")
    @ApiModelProperty(value = "订单状态")
    private String status;

    @TableField("CREATE_TIME")
    @ApiModelProperty(value = "创建日期")
    private Date createTime;

    @TableField("UPDATE_TIME")
    @ApiModelProperty(value = "修改日期")
    private Date updateTime;

    @TableField("ORDER_PRICE")
    @ApiModelProperty(value = "订单金额")
    private BigDecimal orderPrice;

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Order{" +
        "status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
