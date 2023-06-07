package com.wang.order.controller;

import com.wang.order.entity.Order;
import com.wang.order.service.OrderService;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderController.java
 * @Description TODO
 * @createTime 2023年02月02日 13:05:00
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/add")
    public String addOrder(){
        Order order = new Order();
        order.setProductId(1);
        order.setState(0);
        order.setTotalAmount(1);
        orderService.add(order);
        return "新增成功";
    }

    @RequestMapping("/get/{id}")
    public Order getOrder(@PathVariable Integer id){
        Order one = orderService.getOne(id);
        return one;
    }

    @RequestMapping("/getAll")
    public List<Order> all() throws InterruptedException {
        List<Order> orderList = orderService.getAll();
        return orderList;
    }


}
