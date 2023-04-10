package com.fct.feign;

import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixClientImpl implements HystrixClient{
    @Override
    public String test1(Integer id) {
        return "网络故障,当前服务不可达.... id: " + id;
    }
}
