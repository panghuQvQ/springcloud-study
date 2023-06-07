package com.wang.order.controller;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyRequestOriginParser.java
 * @Description TODO 实现 RequestOriginParser接口，在parseOrigin() 方法中区分来源
 * @createTime 2023年01月30日 15:10:00
 */
@Component
public class MyRequestOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {

        // 标识字段名称可以自定义
        String origin = request.getParameter("serviceName");
        // if (StringUtil.isBlank(origin)){
        // throw new IllegalArgumentException("serviceName参数未指定");
        // }
        return origin;
    }
}
