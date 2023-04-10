package com.fct.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Value("${server.port}")
    private int port;

    @GetMapping
    public String invokeOrder(){
        log.info("order demo ...");
        return "order demo is ok...服务端口为:" + port;
    }
}
