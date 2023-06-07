package com.wang.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName LogFliter.java 自定义全局过滤器
 * @Description TODO
 * @createTime 2023年02月07日 13:31:00
 */
@Component
public class LogFilter implements GlobalFilter {

    Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        logger.info(exchange.getRequest().getPath().value());
        return chain.filter(exchange); // 继续向下执行
    }
}
