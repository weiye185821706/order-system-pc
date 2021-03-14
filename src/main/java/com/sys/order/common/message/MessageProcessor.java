package com.sys.order.common.message;

public interface MessageProcessor {

    /**
     * 消息处理
     */
    void process(String message);

}
