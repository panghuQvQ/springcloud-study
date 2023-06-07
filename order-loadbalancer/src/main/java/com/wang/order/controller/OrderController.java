package com.wang.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderController.java
 * @Description TODO
 * @createTime 2022年12月28日 14:35:00
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/add")
    public String add() {
        System.out.println("下单成功");
        String msg = restTemplate.getForObject("http://stock-service/stock/reduct", String.class);
        return "Hello World" + msg;
    }
}
