package com.sys.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sys.order.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@TableName("DISHES")
@ApiModel(value="Dishes对象", description="菜品表")
public class Dishes extends BaseEntity {

    private static final long serialVersionUID=1L;

    @TableField("DISHES_NAME")
    @ApiModelProperty(value = "菜品名称")
    private String dishesName;


    @TableField("DISHES_PRICE")
    @ApiModelProperty(value = "菜品价格")
    private BigDecimal dishesPrice;


    public String getDishesName() {
        return dishesName;
    }

    public void setDishesName(String dishesName) {
        this.dishesName = dishesName;
    }

    public BigDecimal getDishesPrice() {
        return dishesPrice;
    }

    public void setDishesPrice(BigDecimal dishesPrice) {
        this.dishesPrice = dishesPrice;
    }

    @Override
    public String toString() {
        return "Dishes{" +
        "dishesName=" + dishesName +
        ", dishesPrice=" + dishesPrice +
        "}";
    }
}
