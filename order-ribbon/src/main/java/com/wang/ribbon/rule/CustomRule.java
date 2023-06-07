package com.wang.ribbon.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CustomRule.java
 * @Description 自定义负载均衡策略
 * @createTime 2023年01月05日 14:28:00
 */
public class CustomRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {

        ILoadBalancer loadBalancer = this.getLoadBalancer();

        // 获得当前请求的服务的实例
        List<Server> reachableServers = loadBalancer.getReachableServers();
        int random = ThreadLocalRandom.current().nextInt(reachableServers.size());
        Server server = reachableServers.get(random);
//        if(server.isAlive()){
//            return null;
//        }
        return server;
    }
}
