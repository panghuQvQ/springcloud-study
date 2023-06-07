package com.wang.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TestController.java
 * @Description TODO 测试，sentinel是否在调用一个方法时，会把其他控制类的信息都加在进控制中心
 *                   答案：不会，只会加载调用的方法
 * @createTime 2023年01月12日 14:35:00
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/get")
    public String getInfo(){
        return "test";
    }
}
