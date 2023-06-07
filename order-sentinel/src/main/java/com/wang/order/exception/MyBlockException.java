package com.wang.order.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wang.order.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyBlockException.java
 * @Description  异常统一处理类
 * @createTime 2023年01月12日 16:11:00
 */
@Slf4j
@Component
public class MyBlockException implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {

        // getRule() 包含 资源、规则的详细信息
        log.info("BlockExceptionHandler BlockException================"+e.getRule());

        Result r = null;

         if (e instanceof FlowException) {
             r = Result.error(100,"接口限流了");

             } else if (e instanceof DegradeException) {
             r = Result.error(101,"服务降级了");

             } else if (e instanceof ParamFlowException) {
             r = Result.error(102,"热点参数限流了");

             } else if (e instanceof SystemBlockException) {
             r = Result.error(103,"触发系统保护规则了");

             } else if (e instanceof AuthorityException) {
             r = Result.error(104,"授权规则不通过");
             }

         //返回json数据
         response.setStatus(500);
         response.setCharacterEncoding("UTF-8");
         response.setContentType(MediaType.APPLICATION_JSON_VALUE);
         new ObjectMapper().writeValue(response.getWriter(), r);
    }
}
