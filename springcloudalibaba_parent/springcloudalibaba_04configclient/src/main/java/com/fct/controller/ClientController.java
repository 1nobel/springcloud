package com.fct.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope //允许远端配置修改自动刷新
public class ClientController {

    @Value(value = "${abc.username}")
    private String clientUsername;

    @GetMapping("demo")
    public String demo(){
        log.info("-----------client 启动----------------");
        return "统一配置拉取成功,项目正常启动!!!" + clientUsername;
    }
}
