package com.wang.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wang.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderController.java
 * @Description TODO 流控规则 与 热点规则 举例
 * @createTime 2022年12月28日 14:35:00
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderService orderService;

    @RequestMapping("/add")
    public String add() {
        System.out.println("下单成功");
        return "Hello World";
    }


    /**
     * QPS 流控
     *
     * @return
     */
    @GetMapping("/flow")
//    @SentinelResource(value = "flow",blockHandler="flowBlockHandler") // 自定义异常返回结果
    public String flow() {
        return "正常访问";
    }

    /**
     * 注意！！！：
     * 1.一定要 public
     * 2. 返回值一定要和源方法保持一致，包含源方法的参数
     * 3. 必须在参数最后添加 BlockException，可以区分是什么规则的处理方法
     */
    public String flowBlockHandler(BlockException ex) {
        return "流控成功";
    }

    /**
     * 线程 流控
     *
     * @return
     */
    @GetMapping("/flowThread")
    @SentinelResource(value = "flowThread", blockHandler = "flowBlockHandler")
    public String flowThread() throws InterruptedException {
        Thread.sleep(5000);
        return "正常访问";
    }

    //================================================================================================

    /**
     * 流控模式---->关联模式
     * 当下单接口访问次数过多时，查询接口被限流
     * getProduct 关联 addProduct
     *
     * @return
     */
    @RequestMapping("/addProduct")
    public String addProduct() {
        return "下单成功";
    }

    @RequestMapping("/getProduct")
    public String getProduct() {
        return "查询成功";
    }

    //==================================================================================================

    /**
     * 流控模式---->链路模式
     * 允许在访问同一个资源时，对某一个入口进行流控
     * 对 test2 下的 getUser 资源进行流控，链路test1方法
     */
    @RequestMapping("/test1")
    public String Test1() {
        return orderService.getUser();
    }

    @RequestMapping("/test2")
    public String Test2() {
        return orderService.getUser();
    }


    //==================================================================================================

    /**
     * 热点规则： 1.必须使用 @SentinelResource("resourceName") 注解
     *          2.参数必须是7种基本数据类型才会生效
     * 对某一注解进行流控，可配置高级选项，如：当 id 等于某一个数值时，进行流控
     *
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    @SentinelResource(value = "getById", blockHandler = "HotBlockHandler")
    public String getById(@PathVariable("id") Integer id) {
        System.out.println("正常访问");
        return "正常访问";
    }

    public String HotBlockHandler(@PathVariable("id") Integer id, BlockException e) {
        return "热点异常处理";
    }
}
