package com.fct.controller;

import com.fct.feign.ProductFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancerClient loadBalancerClient;


    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ProductFeign productFeign;

    @GetMapping("/test1")
    public String test(Integer id){
        log.info("测试服务调用 id:"+ id);

        /* //只使用restTemplate
        String forObject = new RestTemplate().getForObject("http://localhost:8052/product/test1?id=55", String.class);
        log.info(forObject); */

        //使用discoveryClient 1.引入ribbon依赖(nacos集成的有) 2. 注入discoveryClient
        //1.获取服务列表
       /*  List<ServiceInstance> products = discoveryClient.getInstances("PRODUCTS");
        for(ServiceInstance product: products){
            log.info("host:{} uri:{} port:{}",product.getHost(),product.getUri(),product.getPort());
        }
        //2.使用restTemplate发送http请求
        String forObject = new RestTemplate().getForObject(products.get(0).getUri() + "/product/test1?id=88", String.class);
        log.info(forObject); */

       /*  //3.使用loadBalanced
        ServiceInstance products = loadBalancerClient.choose("PRODUCTS");
        String forObject = new RestTemplate().getForObject(products.getUri() + "/product/test1?id=12", String.class);
        log.info(forObject); */

        //4.使用@LoadBalanced
     /*    String forObject = restTemplate.getForObject("http://PRODUCTS/product/test1?id=22", String.class);
        log.info(forObject); */

        //5.openfeign
        String forObject = productFeign.test1(id);

        return forObject;
    }

}
