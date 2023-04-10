package com.fct.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping
    public String invokeUser(){
        log.info("user demo...");
        //调用订单服务 服务通信 现有的restTemplate在进行服务间通信时,将服务端口谢死在url上无法实现服务集群时请求的负载均衡 路径写死不利于维护
//        RestTemplate restTemplate = new RestTemplate();
//        String template = restTemplate.getForObject("http://"+hostRandom()+"/order", String.class);
//        log.info("{}",template);

        //discoveryClient获取服务列表
//        List<ServiceInstance> orders = discoveryClient.getInstances("ORDERS");
//        orders.forEach(order ->{
//            log.info("服务端口{},服务主机{},服务地址{}",order.getPort(),order.getHost(),order.getUri());
//        });
//        String template = new RestTemplate().getForObject(orders.get(0).getUri()+"/order", String.class);

        //loadBalancerClient负载均衡
//        ServiceInstance orders = loadBalancerClient.choose("ORDERS");
//        String template = new RestTemplate().getForObject(orders.getUri()+ "/order", String.class);

        //@LoadBalanced注解实现负载均衡
        String template = restTemplate.getForObject("http://ORDERS/order", String.class);

        return "调用order服务成功:"+template;
    }

    // 自定义随机策略
    public String hostRandom(){
        List<String> hosts = new ArrayList<>();
        hosts.add("localhost:8012");
        hosts.add("localhost:8013");
        int i = new Random().nextInt(hosts.size());

        return hosts.get(i);
    }

}
