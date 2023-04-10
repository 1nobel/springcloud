package com.fct.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@Slf4j
@RequestMapping("sentinel")
public class SentinelController {

    @GetMapping("test1")
    @SentinelResource(value = "aaaa", blockHandler = "blockHandler", fallback = "fallback")
    public String test1(Integer id){
        if(id < 0){
            throw new RuntimeException("数据格式有误...");
        }
        log.info("test1服务被调用");
        return "sentinel test ok, id:"+ id;
    }

    public String blockHandler(Integer id, BlockException blockException){
        if(blockException instanceof FlowException){
            return "当前服务过于火爆,您已被流控";
        }
        if(blockException instanceof ParamFlowException){
            return "当前服务过于火爆,您已被热点参数限流";
        }
        if(blockException instanceof DegradeException){
            return "当前服务过于火爆,您已被降级";
        }
        if (blockException instanceof AuthorityException){
            return "没有权限访问...";
        }
            return "服务器快爆了,请稍后再试";
    }

    public String fallback(Integer id){
        return "服务器异常";
    }

    @GetMapping("demo")
    public String demo(){
        log.info("demo 被调用...");
        return "demo is ok!!!";
    }
}
