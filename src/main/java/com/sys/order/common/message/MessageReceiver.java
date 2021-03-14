package com.sys.order.common.message;

import com.sys.order.entity.MessageTypeEnum;
import com.sys.order.vo.message.MessageProcessorVo;

/**
 * 消息通知接口
 */
public interface MessageReceiver {

    /**
     * 注册订阅者
     */
    void registerSubscriber(MessageProcessorVo vo);

    /**
     * 移除订阅者
     */
    void removeSubscriber(MessageProcessorVo vo);

//    /**
//     * 通知指定人
//     *
//     * @param messageTypeEnum 消息类型
//     */
//     void notification(MessageTypeEnum messageTypeEnum);
//
//    /**
//     * 消息通知 所有人
//     */
//    void notificationAll();



}
