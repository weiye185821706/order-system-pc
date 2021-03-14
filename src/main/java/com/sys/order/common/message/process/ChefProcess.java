package com.sys.order.common.message.process;

import com.sys.order.common.message.MessageProcessor;
import org.springframework.stereotype.Component;

/**
 * 厨师通知
 */
@Component
public class ChefProcess implements MessageProcessor {
    @Override
    public void process(String message) {
        System.out.println(message);
    }
}
