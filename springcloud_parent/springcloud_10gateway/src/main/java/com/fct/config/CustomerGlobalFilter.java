package com.fct.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class CustomerGlobalFilter implements GlobalFilter, Ordered {


    //基于webflux
    //exchange: 交换 request response 封装了request response
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //httpRequest对象
        ServerHttpRequest request = exchange.getRequest();
        //httpResponse对象
        ServerHttpResponse response = exchange.getResponse();

        System.out.println("经过全局filter处理......");
        Mono<Void> filter = chain.filter(exchange);
        System.out.println("响应回来filter处理......");
        return filter;
    }

    //排序 0,1,2.......
    @Override
    public int getOrder() {
        return 0;
    }
}
