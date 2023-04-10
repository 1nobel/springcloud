package com.fct.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {

    @GetMapping("test1")
    @HystrixCommand(fallbackMethod = "back", defaultFallback = "defaultFallback")
    public String test1(Integer id){
        if(id<= 0){
            throw new RuntimeException("请输入合法的id...");
        }
        return "test ok...";
    }

    public String defaultFallback(){
        return "网络故障,请稍后再试!!!";
    }

    public String back(Integer id){

        return "服务已经被熔断...";
    }
}
