package com.sys.order.vo.message;


import com.sys.order.common.message.MessageProcessor;
import com.sys.order.entity.MessageTypeEnum;

import java.io.Serializable;

/**
 * 设置处理消息业务实体
 */
public class MessageProcessorVo implements Serializable {

    private MessageProcessor messageProcessor; // 消费消息服务类

    private MessageTypeEnum messageTypeEnum; // 消息类型

    private MessageProcessorVo() {
    }

    public MessageProcessorVo(MessageProcessor messageProcessor, MessageTypeEnum messageTypeEnum) {
        this.messageProcessor = messageProcessor;
        this.messageTypeEnum = messageTypeEnum;
    }

    public MessageTypeEnum getMessageTypeEnum() {
        return messageTypeEnum;
    }

    public MessageProcessor getMessageProcessor() {
        return messageProcessor;
    }

    public void setMessageProcessor(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }
}
