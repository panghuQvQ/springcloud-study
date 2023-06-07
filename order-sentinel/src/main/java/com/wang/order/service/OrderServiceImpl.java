package com.wang.order.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderServiceImpl.java
 * @Description TODO
 * @createTime 2023年01月13日 11:08:00
 */
@Service
public class OrderServiceImpl implements OrderService{


    @Override
    @SentinelResource(value = "",blockHandler = "getUserBlockHandler")
    public String getUser() {
        return "查询用户";
    }

    public String getUserBlockHandler(BlockException e) {
        return "查询用户流控成功";
    }
}
