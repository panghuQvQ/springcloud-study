package com.wang.order.feign;

import org.springframework.stereotype.Component;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ConsumerFallBackService.java
 * @Description TODO
 * @createTime 2023年01月16日 16:22:00
 */
@Component
public class StockFeignServiceFallBack implements StockFeignService{
    @Override
    public String add() {
        return "降级了！！！";
    }
}
