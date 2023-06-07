package com.wang.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderApplication.java
 * @Description TODO
 * @createTime 2022年12月28日 14:45:00
 */
@SpringBootApplication
@EnableFeignClients // 第4步
public class OrderOpenFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignApplication.class,args);
    }
}
