package com.sys.order.config;

import com.sys.order.common.message.MessageProcessor;
import com.sys.order.common.message.MessageReceiverDefinition;
import com.sys.order.entity.MessageTypeEnum;
import com.sys.order.vo.message.MessageProcessorVo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class BeanConfig {

    @Resource(name = "chefProcess")
    private MessageProcessor chefProcess;

    @Resource(name = "userProcess")
    private MessageProcessor userProcess;

    @Resource(name = "waiterProcess")
    private MessageProcessor waiterProcess;

    @Bean
    public MessageReceiverDefinition messageReceiverDefinition() {
        MessageReceiverDefinition definition = new MessageReceiverDefinition();
        // 注册厨师
        definition.registerSubscriber(new MessageProcessorVo(chefProcess, MessageTypeEnum.CHEF));
        // 注册用户
        definition.registerSubscriber(new MessageProcessorVo(userProcess, MessageTypeEnum.USER));
        // 注册服务员
        definition.registerSubscriber(new MessageProcessorVo(waiterProcess, MessageTypeEnum.WAITER));
        return definition;
    }

}
