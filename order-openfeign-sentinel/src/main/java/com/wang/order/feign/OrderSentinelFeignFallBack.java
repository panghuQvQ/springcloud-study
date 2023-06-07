package com.wang.order.feign;

import org.springframework.stereotype.Component;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderSentinelFeignFallBack.java
 * @Description TODO
 * @createTime 2023年01月16日 16:59:00
 */
@Component
public class OrderSentinelFeignFallBack implements OrderSentinelFeign{
    @Override
    public String add() {
        return "限流啦！！！";
    }
}
