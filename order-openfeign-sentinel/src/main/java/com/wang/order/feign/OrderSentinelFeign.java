package com.wang.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderSentinelFeign.java
 * @Description TODO
 * @createTime 2023年01月16日 16:57:00
 */
@FeignClient(value = "order-sentinel",fallback = OrderSentinelFeignFallBack.class)
public interface OrderSentinelFeign {

    @RequestMapping("/order/add")
    public String add();

}
