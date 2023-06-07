package com.wang.stock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName StockController.java
 * @Description TODO
 * @createTime 2022年12月28日 14:38:00
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/reduct")
    public String reduct() {
        System.out.println("扣减库存");
        return "扣减库存" + port;
    }

    @RequestMapping("/add")
    public String add() {
        int i = 1 / 0;
        System.out.println("添加库存");
        return "添加库存";
    }
}
