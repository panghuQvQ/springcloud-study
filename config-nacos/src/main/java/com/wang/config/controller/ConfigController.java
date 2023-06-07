package com.wang.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ConfigController.java
 * @Description TODO
 * @createTime 2023年01月10日 14:13:00
 */
@RestController
@RequestMapping("/config")
@RefreshScope // @Value注解可以获取到配置中心的值，但是无法动态感知修改后的值，需要利用@RefreshScope注解
public class ConfigController {

    @Value("${user.name}")
    public String username;

    @GetMapping("/show")
    public String show() {
        return username;
    }

}
