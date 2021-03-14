package com.sys.order.common.message.process;

import com.sys.order.common.message.MessageProcessor;
import org.springframework.stereotype.Component;

/**
 * 用户通知
 */
@Component
public class UserProcess implements MessageProcessor {
    @Override
    public void process(String message) {
        System.out.println(message);
    }
}
