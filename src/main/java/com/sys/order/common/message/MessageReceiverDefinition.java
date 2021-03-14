package com.sys.order.common.message;

import com.sys.order.entity.MessageTypeEnum;
import com.sys.order.exception.MyException;
import com.sys.order.vo.message.MessageProcessorVo;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 程序启动的时候默认注册厨师，服务员，用户到观察者（config配置注册）
 */
public class MessageReceiverDefinition implements MessageReceiver {

    private final static CopyOnWriteArrayList<MessageProcessorVo> messageProcessorVos = new CopyOnWriteArrayList<>();


    @Override
    public void registerSubscriber(MessageProcessorVo vo) {
        messageProcessorVos.add(vo);
    }

    @Override
    public void removeSubscriber(MessageProcessorVo vo) {
        messageProcessorVos.remove(vo);
    }

    /**
     * 通知指定人
     *
     * @param messageTypeEnum 消息类型
     */
    public static void notification(String message,MessageTypeEnum... messageTypeEnum) {
        if (messageTypeEnum == null) {
            throw new MyException("消息类型不能为空");
        }
        if (messageProcessorVos.isEmpty()) {
            throw new MyException("当前没有任何消息者注册进服务");
        }
        messageProcessorVos.forEach(e -> {
            for (MessageTypeEnum typeEnum : messageTypeEnum) {
                if (e.getMessageTypeEnum().equals(typeEnum)) {
                    e.getMessageProcessor().process(message);
                }
            }
        });
    }

    /**
     * 通知所有人
     */
    public static void notificationAll(String message) {
        if (messageProcessorVos.isEmpty()) {
            throw new MyException("当前没有任何消息者注册进服务");
        }
        messageProcessorVos.forEach(e -> {
            e.getMessageProcessor().process(message);
        });
    }

}
