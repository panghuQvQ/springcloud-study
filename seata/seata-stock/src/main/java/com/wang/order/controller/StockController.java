package com.wang.order.controller;

import com.wang.order.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderController.java
 * @Description TODO
 * @createTime 2023年02月02日 13:05:00
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @RequestMapping("/update")
    public String updateStock(){
        stockService.updateStock();
        return "修改成功";
    }

}
