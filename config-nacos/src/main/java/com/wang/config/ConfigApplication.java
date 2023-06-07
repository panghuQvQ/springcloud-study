package com.wang.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ConfigApplication.java
 * @Description TODO
 * @createTime 2023年01月09日 16:16:00
 */
@SpringBootApplication
public class ConfigApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConfigApplication.class, args);

        while (true) {
            // 此处代码为，每100秒输出（nacos客户端中配置的）配置文件中的信息
            String userName = applicationContext.getEnvironment().getProperty("user.name");
            String userAge = applicationContext.getEnvironment().getProperty("user.age");
            String config = applicationContext.getEnvironment().getProperty("user.config");
            System.err.println("user name :" + userName + "; age: " + userAge + ";config: " + config);
            TimeUnit.SECONDS.sleep(1);

            // nacos客户端 每10ms去 注册中心进行判断， 根据MD5进行比较，不一致就会输出
        }

    }
}
