package com.wang.order.feign;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName StockFeignService.java
 * @Description
 * @createTime 2023年01月05日 16:28:00
 */
@FeignClient(name = "product-service", path = "/product")
public interface ProductFeignService {

//    @RequestMapping("/{id}") // 对应 Feign的原生注解是：@RequestLine
//    public String get(@PathVariable("id") Integer id); // 对应 Feign的原生注解是：@Param； 使用@PathVariable() 必须指定参数


    // 使用 Feign原生注解说明
    @RequestLine("GET /{id}")
    public String get(@Param("id") Integer id);
}
