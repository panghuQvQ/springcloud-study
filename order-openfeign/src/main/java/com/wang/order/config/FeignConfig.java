package com.wang.order.config;

import com.wang.order.interceptor.feign.CustomFeignInterceptor;
import feign.Contract;
import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 日志配置类：
 * 全局配置： 当使用 @Configuration 会将配置作用所有的服务提供方
 * 局部配置： 1.通过配置类：如果只想针对某一个服务进行配置，就不要加 @Configuration
 * 2.通过配置文件
 */
//@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feginLoggerLevel() {
        return Logger.Level.FULL;
    } // 记录请求和响应的header、body和元数据

    /**
     * 修改契约配置，支持Feign原生的注解
     * 注意：修改契约配置后，OrderFeignService 不再支持springmvc的注解，需要使用Feign原生的注解
     * @return
     */
//    @Bean
//    public Contract feignContract() {
//        return new Contract.Default();
//    }

    /**
     * 全局配置，超时时间
     */
//    @Bean
//    public Request.Options options(){
//        return new Request.Options(5000,10000);
//    }

    /**
     * 全局配置，自定义拦截器
     */
//    @Bean
//    public CustomFeignInterceptor feignAuthRequestInterceptor(){
//        return new CustomFeignInterceptor();
//    }
}
