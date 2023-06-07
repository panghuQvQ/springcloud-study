package com.wang.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SeataOrderApplication.java
 * @Description TODO
 * @createTime 2023年02月02日 13:07:00
 */
@SpringBootApplication
@MapperScan("com.wang.order.mapper")
//@EnableTransactionManagement
public class SeataStockApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeataStockApplication.class, args);
    }
}
