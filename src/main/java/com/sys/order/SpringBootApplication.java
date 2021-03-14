package com.sys.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

@org.springframework.boot.autoconfigure.SpringBootApplication
@MapperScan("com.sys.order.dao")
public class SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

}
