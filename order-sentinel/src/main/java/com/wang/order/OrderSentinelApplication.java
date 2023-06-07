package com.wang.order;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderApplication.java
 * @Description TODO
 * @createTime 2022年12月28日 14:45:00
 */
@SpringBootApplication
public class OrderSentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderSentinelApplication.class,args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        RestTemplate restTemplate = builder.build();
        return restTemplate;
    }
}
