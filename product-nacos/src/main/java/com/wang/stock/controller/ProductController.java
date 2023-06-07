package com.wang.stock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/product")
public class ProductController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/{id}")
    public String get(@PathVariable Integer id) throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("查询商品" + id);
        return "查询商品" + id + port;
    }
}
