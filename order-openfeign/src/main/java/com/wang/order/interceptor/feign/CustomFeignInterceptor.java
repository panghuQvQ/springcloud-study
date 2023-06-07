package com.wang.order.interceptor.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CustomFeignInterceptor.java
 * @Description TODO 自定义拦截器
 * @createTime 2023年01月06日 17:14:00
 */
public class CustomFeignInterceptor implements RequestInterceptor {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void apply(RequestTemplate requestTemplate) {

        // TODO 日志，授权都可以

        logger.info("feign拦截器！");
    }
}
