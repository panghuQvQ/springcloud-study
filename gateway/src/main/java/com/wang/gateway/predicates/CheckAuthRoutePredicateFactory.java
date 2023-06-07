package com.wang.gateway.predicates;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CheckAuthRoutePredicateFactory.java  自定义断言
 * @Description TODO   可参照 QueryRoutePredicateFactory.class 来自定义 配置文件
 *
 * 1、 必须spring组件 bean
 * 2. 类必须加上RoutePredicateFactory作为结尾
 * 3. 必须继承AbstractRoutePredicateFactory
 * 4. 必须声明静态内部类 声明属性来接收 配置文件中对应的断言的信息
 * 5. 需要结合shortcutFieldOrder进行绑定
 * 6.通过apply进行逻辑判断 true就是匹配成功 false匹配失败
 *
 * @createTime 2023年02月06日 17:12:00
 */
@Component
public class CheckAuthRoutePredicateFactory extends AbstractRoutePredicateFactory<CheckAuthRoutePredicateFactory.Config> {

    public CheckAuthRoutePredicateFactory() {
        super(CheckAuthRoutePredicateFactory.Config.class);
    }

    public List<String> shortcutFieldOrder() {
        return Arrays.asList("name");
    }

    public Predicate<ServerWebExchange> apply(CheckAuthRoutePredicateFactory.Config config) {
        return new GatewayPredicate() {
            public boolean test(ServerWebExchange exchange) {
                if(config.getName().equals("wzy")){
                    return true;
                }
                return false;
            }
        };
    }

    // 用于接收配置文件中 断言的信息
    @Validated
    public static class Config {
        private String name; // 用于接收 配置信息

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
