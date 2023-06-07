package com.wang.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

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


    @RequestMapping("/header")
    public String header(@RequestHeader("X-Request-color") String color) {

        return color;
    }


    @RequestMapping("/addProduct")
    public String addProduct() {
        return "下单成功";
    }

    @RequestMapping("/getProduct")
    public String getProduct() {
        return "查询成功";
    }

}
