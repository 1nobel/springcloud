package com.fct.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "HYSTRIX", fallback = HystrixClientImpl.class) //fallback: 这个属性用来指定当前调用服务不可用时,默认备选处理
public interface HystrixClient {

    @GetMapping("test1")
    String test1(@RequestParam("id") Integer id);

}
