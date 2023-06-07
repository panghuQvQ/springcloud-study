package com.wang.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wang.order.entity.Order;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderService.java
 * @Description TODO
 * @createTime 2023年02月02日 13:06:00
 */
public interface OrderService extends IService<Order> {

    void add(Order order);

    Order getOne(Integer id);

    List<Order> getAll() throws InterruptedException;
}
