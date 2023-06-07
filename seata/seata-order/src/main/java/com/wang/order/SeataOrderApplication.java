package com.wang.order;

import io.seata.spring.annotation.GlobalTransactional;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SeataOrderApplication.java
 * @Description TODO 配置 seata 流程
 *      1. 添加依赖
 *      2. 数据库中添加 undo_log 日志表
 *      3. application.yml 中添加 seata 配置，添加事务分组
 *      4. 方法上添加 @GlobalTransactional
 * @createTime 2023年02月02日 13:07:00
 */
@SpringBootApplication
@MapperScan("com.wang.order.mapper")
@EnableFeignClients // 开启Feign
//@EnableTransactionManagement
//@GlobalTransactional
public class SeataOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderApplication.class, args);
    }
}
