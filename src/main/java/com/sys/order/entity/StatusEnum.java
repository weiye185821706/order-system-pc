package com.sys.order.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusEnum {
    // 订单状态
	ORDER_START("1","开始下单"),
    ORDER_PICK_UP("2","厨师接单"),
    ORDER_SUCCESS("3","订单完成"),
    ORDER_RETURN("4","退单完成"),
    // 菜品状态
    ON_START("10","未开始制作"),
    START("20","开始制作"),
    SUCCESS("30","制作完成"),
    OK("40","上菜完成"),
    RETURN_DIS("50","退菜成功");
    private final String value;
    private final String display;

    private StatusEnum(String value, String display){
        this.display = display;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getDisplay() {
        return display;
    }

    @JsonCreator
    public static StatusEnum create(String value) {
        try {
            return StatusEnum.valueOf(value);
        } catch (IllegalArgumentException e) {
            for (StatusEnum enums : StatusEnum.values()) {
                if (enums.value.equals(value)) {
                    return enums;
                }
            }
        }
        throw new IllegalArgumentException("No element matches " + value);
    }

    public static String getValue(String type) {
        StatusEnum[] enums = values();
        for (StatusEnum enumIndex : enums) {
            if (enumIndex.getValue().equals(type)) {
                return enumIndex.getDisplay();
            }
        }
        return null;
    }
}
