package com.sys.order.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum MessageTypeEnum {

    USER("user", "用户"), CHEF("chef", "厨师"), WAITER("waiter", "服务员");

    private final String value;
    private final String display;

    private MessageTypeEnum(String value, String display) {
        this.display = display;
        this.value = value;
    }

    public String getDisplay() {
        return display;
    }

    public String getValue() {
        return value;
    }

    @JsonCreator
    public static MessageTypeEnum create(String value) {
        try {
            return MessageTypeEnum.valueOf(value);
        } catch (IllegalArgumentException e) {
            for (MessageTypeEnum enums : MessageTypeEnum.values()) {
                if (enums.value.equals(value)) {
                    return enums;
                }
            }
        }
        throw new IllegalArgumentException("No element matches " + value);
    }

    public static String getValue(String type) {
        MessageTypeEnum[] enums = values();
        for (MessageTypeEnum enumIndex : enums) {
            if (enumIndex.getValue().equals(type)) {
                return enumIndex.getDisplay();
            }
        }
        return null;
    }

}
