package com.fct.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("product")
public class ProductController {

    @Value("${server.port}")
    private String port;

    @GetMapping("test1")
    public String test1(Integer id){
        log.info("product 服务已经启动 id:{},port:{}",id,port);
        return "product 服务已被调用 id:" + id + "port:" + port;

    }
}
