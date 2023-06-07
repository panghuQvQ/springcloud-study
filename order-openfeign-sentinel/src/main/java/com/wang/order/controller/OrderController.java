package com.wang.order.controller;

import com.wang.order.feign.OrderSentinelFeign;
import com.wang.order.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 第三步，引入
     */
    @Autowired
    StockFeignService stockFeignService;

    @Autowired
    OrderSentinelFeign orderSentinelFeign;


    @RequestMapping("/add")
    public String add() {
        System.out.println("下单成功");
        String stockMsg = stockFeignService.add();
        return "Hello World" + stockMsg;
    }

    @RequestMapping("/add2")
    public String add2() {
        System.out.println("下单成功");
        String orderMsg = orderSentinelFeign.add();
        return "Hello World" + orderMsg;
    }
}
