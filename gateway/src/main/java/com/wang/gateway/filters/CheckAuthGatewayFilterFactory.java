package com.wang.gateway.filters;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CheckAuthGatewayFilterFactory.java  自定义网关过滤器
 * @Description TODO
 * @createTime 2023年02月07日 10:27:00
 */
@Component
public class CheckAuthGatewayFilterFactory extends AbstractGatewayFilterFactory<CheckAuthGatewayFilterFactory.Config> {


    public CheckAuthGatewayFilterFactory() {
        super(CheckAuthGatewayFilterFactory.Config.class);
    }

    public List<String> shortcutFieldOrder() {
        return Arrays.asList("name", "value");
    }

    @Override
    public GatewayFilter apply(CheckAuthGatewayFilterFactory.Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                String name = exchange.getRequest().getQueryParams().getFirst("name");
                // 获取 name 参数的值
                if (StringUtils.isNotBlank(name)) {
                    if(config.getValue().equals(name)){
                        return chain.filter(exchange);
                    }else {
                        // 返回 404
                        exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
                        return exchange.getResponse().setComplete();
                    }
                }
                // 正常请求
                return chain.filter(exchange);
            }
        };
    }


    public static class Config {
        private String name;

        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
