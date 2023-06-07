package com.wang.order.feign;

import com.wang.order.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName StockFeignService.java
 * @Description
 * 第二步：
 * name 指定调用rest 接口所对应的服务名
 * path 指定调用rest 接口所在的StockController 指定的 @requestMapping
 * @createTime 2023年01月05日 16:28:00
 */
@FeignClient(value = "stock-service",path = "/stock",configuration = FeignConfig.class)
public interface StockFeignService {

    @RequestMapping("/reduct")
    public String reduct();
}
