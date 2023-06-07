package com.wang.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName RibbonRandomRuleConfig.java
 * @Description 此处有坑。不能写在@SpringbootApplication注解的@CompentScan扫描得到的地方，否则自定义的配置类就会被所有的
 *              RibbonClients共享。 不建议这么使用，推荐yml方式
 *              在 OrderApplication 中有使用
 * @createTime 2022年12月30日 16:49:00
 */
@Configuration
public class RibbonRandomRuleConfig {

    /**
     * 方法名一定叫 IRule
     * @return
     */
    @Bean
    public IRule iRule(){
       return new RandomRule();
    }
}
