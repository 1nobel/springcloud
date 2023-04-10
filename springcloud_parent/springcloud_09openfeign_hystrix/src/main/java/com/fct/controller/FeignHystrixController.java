package com.fct.controller;

import com.fct.feign.HystrixClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignHystrixController {

    @Resource
    private HystrixClient hystrixClient;

    @GetMapping("test")
    public String test(){
        System.out.println("test...");
        String s = hystrixClient.test1(-1);
        System.out.println(s);
        return "test ok..." + s;
    }
}
