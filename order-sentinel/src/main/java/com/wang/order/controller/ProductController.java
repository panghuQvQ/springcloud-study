package com.wang.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ProductController.java
 * @Description TODO 降级规则 举例
 * @createTime 2023/1/30 13:51
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 降级规则---->慢调用比例
     * 当每秒的请求数大于 sentinel设置的最小请求数，且存在请求响应时间超过 设置的最大 RT 的比例大于 设置的比例阈值，则进行熔断降级
     *
     * @return
     */
    @RequestMapping("/add")
    public String addProduct() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "========addProduct()========";
    }

    //=======================================================================================================

    /**
     * 降级规则---->异常比例 / 异常数比例
     * 当每秒的请求数大于 sentinel设置的最小请求数，且存在请求响应时间超过 设置的最大 RT 的比例大于 设置的比例阈值，则进行熔断降级
     *
     * @return
     */
    @RequestMapping("/delete")
    public String deleteProduct() {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndAdd(2);
        if (atomicInteger.get() % 2 == 0) {
            //模拟异常和异常比率
            int i = 1 / 0;
        }

        return "========test2()========";
    }

    //=======================================================================================================

    /**
     * 授权规则，搭配 MyRequestOriginParser 使用
     * 请求链接：http://localhost:8061/product/update?serviceName= XXX
     * @return
     */
    @RequestMapping("/update")
    public String getById1(@RequestParam("serviceName") String serviceName) {
        System.out.println("正常访问");
        return "正常访问";
    }

}
