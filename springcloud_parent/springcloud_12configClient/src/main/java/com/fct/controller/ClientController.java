package com.fct.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope // 在不用重启微服务的情况下,将scope域中信息刷新为最新配置信息
public class ClientController {

    @Value("${name}")
    private String name;


    @GetMapping("demo")
    public String demo(){
        return "demo ok......"+ name;
    }
}
