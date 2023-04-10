package com.fct.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "PRODUCTS")
public interface ProductFeign {

    @GetMapping("product/test1")
    String test1(@RequestParam("id") Integer id);
}
