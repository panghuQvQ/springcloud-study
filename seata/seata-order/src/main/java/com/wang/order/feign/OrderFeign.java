package com.wang.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderFeign.java
 * @Description TODO
 * @createTime 2023年02月02日 17:03:00
 */
@FeignClient(value = "seata-stock")
public interface OrderFeign {

    @RequestMapping("/stock/update")
    public String updateStock();
}
