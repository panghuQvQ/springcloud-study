package com.wang.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.order.entity.Order;
import com.wang.order.feign.OrderFeign;
import com.wang.order.mapper.OrderMapper;
import com.wang.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Tags;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderServiceImpl.java
 * @Description TODO
 * @createTime 2023年02月02日 13:10:00
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    OrderFeign orderFeign;

    @Override
    @GlobalTransactional
    public void add(Order order) {

        // 插入成功
        this.save(order);

        // 调用库存服务
        orderFeign.updateStock();

        // 异常
        int a = 1 / 0;

    }

    @Override
    @Trace
    @Tags({@Tag(key = "getOne", value = "returnedObj"), @Tag(key = "param", value = "arg[0]")})
    public Order getOne(Integer id) {
        Wrapper<Order> wrapper = new QueryWrapper<Order>().eq("id", id);
        Order one = this.getOne(wrapper);
        return one;

    }

    @Override
    @Trace
    @Tag(key = "getAll", value = "returnedObj")
    public List<Order> getAll() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return this.list();
    }
}
