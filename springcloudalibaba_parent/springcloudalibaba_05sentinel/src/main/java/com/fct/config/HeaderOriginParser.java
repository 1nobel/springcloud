package com.fct.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class HeaderOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        // 1. 获取 origin 请求头的内容作为标识信息。
        String origin = httpServletRequest.getHeader("origin");
        // 2. 非空判断 若为空设置请求头为blank
        if (origin.isEmpty()||origin==null) {
            origin = "blank";
        }
        // 否则直接返回
        return origin;
    }

}