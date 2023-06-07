package com.wang.sentinel.controller;

import ch.qos.logback.core.util.TimeUtil;
import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.wang.sentinel.entity.User;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.tools.Trace;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName HelloController.java
 * @Description TODO
 * @createTime 2023年01月11日 10:21:00
 */
@RestController
@RequestMapping("/sentinel")
@Slf4j
public class HelloController {

    private static final String RESOURCE_NAME = "/sentinel/hello";
    private static final String USER_RESOURCE_NAME = "/sentinel/user";
    private static final String DEGRADE_RESOURCE_NAME = "/sentinel/degrade";

    @RequestMapping("/hello")
    public String hello() {

        Entry entry = null;

        try {
            // sentinel针对资源进行限制
            entry = SphU.entry(RESOURCE_NAME);
            // 被保护的业务逻辑
            String str = "hello world";

            log.info("======" + str + "=====");
            return str;
        } catch (BlockException e) {

            // 资源访问阻止，被限流或被降级
            // 进行响应的处理操作
            log.info("block!");
            return "被流控了!";
        } catch (Exception ex) {
            // 若需要配置降级规则，需要通过这种方式记录业务异常
            Tracer.traceEntry(ex, entry);
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
        return null;
    }

    /**
     * 定义流控规则
     *
     * @PostConstruct Spring的初始化方法，在Bean初始化时，调用此方法
     */
    @PostConstruct
    private static void initFlowRules() {
        // 流控规则
        List<FlowRule> rules = new ArrayList<>();

        // 流控
        FlowRule rule = new FlowRule();
        // 为哪个资源进行流控
        rule.setResource(RESOURCE_NAME);
        // 设置流控规则 QPS
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 设置受保护的资源阈值 set limit QPS to 20
        rule.setCount(1);
        rules.add(rule);


        // 通过@SentinelResource 来定义资源并配置降级和流控的处理方法
        FlowRule rule1 = new FlowRule();
        // 设置受保护的资源
        rule1.setResource(USER_RESOURCE_NAME);
        // 设置流控规则 QPS
        rule1.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 设置受保护的资源阈值 set limit QPS to 20
        rule1.setCount(1);
        rules.add(rule1);

        // 加载配置好的规则
        FlowRuleManager.loadRules(rules);
    }


    /**
     * 定义降级规则
     *
     * @PostConstruct Spring的初始化方法，在Bean初始化时，调用此方法
     */
    @PostConstruct
    public void initDegradeRule() {
        /**
         * 降级规则 异常
         */
        List<DegradeRule> degradeRules = new ArrayList<>();
        DegradeRule degradeRule = new DegradeRule();
        degradeRule.setResource(DEGRADE_RESOURCE_NAME);
        // 设置降级规则的策略： 异常数
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        // 设置异常数：2
        degradeRule.setCount(2);
        // 触发熔断的最小请求数
        degradeRule.setMinRequestAmount(2);
        // 统计时长：1分钟  单位：ms
        degradeRule.setStatIntervalMs(60*1000*60); // 时间太短不好测试

        // 代码总结：一分钟内，执行了2次，出现了2次异常，就会触发熔断

        // 熔断持续时长： 单位：s
        // 一旦触发了熔断，再次请求对应的接口就会直接调用 降级方法。
        // 10秒过了之后--->熔断器处于半开状态：恢复接口的请求调用，如果第一次请求就异常，再次熔断，不会根据设置的条件进行判定
        degradeRule.setTimeWindow(10);

        degradeRules.add(degradeRule);
        DegradeRuleManager.loadRules(degradeRules);

    }

    /**

     * @SentinelResource 改善接口中资源定义和被流控降级后的处理方法
     * 怎么使用：
     *      1.添加依赖--->sentinel-annotation-aspectj
     *      2.配置Bean--->SentinelResourceAspect
     *
     *  value: 定义资源
     *  blockHandler：出现流控降级后的处理方法（默认该方法必须生命在同一个类中）
     *      !!  如果不想在同一个类，可通过 blockHandlerClass进行设置，但是方法必须是 static 静态的
     *  fallback: 当接口出现了异常，就可以交给 fallback 指定的方法进行处理
     *      ！！  当 fallback 与 blockHandler 同时制定了，则 blockHandler优先级更高
     *  exceptionsToIgnore：排除那些异常不处理
     * @return
     */
    @RequestMapping("/user")
    @SentinelResource(value = USER_RESOURCE_NAME,
            blockHandler = "blockHandlerForGetUser",
            fallback = "fallbackHandlerForGetUser"
            /*blockHandlerClass = User.class,
            exceptionsToIgnore = {ArithmeticException.class}*/
    )
    public User getUser(String id) {
        int i = 1 / 0;
        return new User("wzy");
    }

    /**
     * 注意！！！：
     *      1.一定要 public
     *      2. 返回值一定要和源方法保持一致，包含源方法的参数
     *      3. 必须在参数最后添加 BlockException，可以区分是什么规则的处理方法
     *
     * @param id
     * @param ex
     * @return
     */
    public User blockHandlerForGetUser(String id, BlockException ex) {
        ex.printStackTrace();
        return new User("流控!!!");
    }

    public User fallbackHandlerForGetUser(String id, Throwable th) {
        th.printStackTrace();
        return new User("异常处理!!!");
    }

    @RequestMapping("/degrade")
    @SentinelResource(value = DEGRADE_RESOURCE_NAME,entryType = EntryType.IN,blockHandler = "blockHandlerForFb")
    public User degrade(String id) throws InterruptedException{
        throw new RuntimeException("异常");

//        TimeUnit.SECONDS.sleep(1);
//        return new User("正常");
    }

    public User blockHandlerForFb(String id,BlockException ex){
        return new User("熔断降级!!!");
    }

}
