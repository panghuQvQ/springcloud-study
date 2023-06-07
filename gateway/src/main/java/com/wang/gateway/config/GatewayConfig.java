package com.wang.gateway.config;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName GatewayConfig.java
 * @Description TODO 自定义异常处理
 * @createTime 2023年02月07日 16:24:00
 */
@Configuration
public class GatewayConfig {

    @PostConstruct
    public void init() {
        BlockRequestHandler blockRequestHandler = new BlockRequestHandler() {
            @Override
            public Mono<ServerResponse> handleRequest(ServerWebExchange exchange, Throwable throwable) {

                System.out.println(throwable);
                HashMap<String, String> map = new HashMap<>();
                map.put("code",HttpStatus.TOO_MANY_REQUESTS.toString());
                map.put("message","限流了");

                // 自定义异常处理
                return ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(map));
            }
        };

        GatewayCallbackManager.setBlockHandler(blockRequestHandler);
    }
}
