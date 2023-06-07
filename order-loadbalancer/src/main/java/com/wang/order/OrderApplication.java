package com.wang.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
//@RibbonClients(value = {
//        @RibbonClient(name = "stock-service",configuration = RibbonRandomRuleConfig.class)
//})
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        RestTemplate restTemplate = builder.build();
        return restTemplate;
    }
}
