package com.fct.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

  /*  @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                //类别路由
                .route("category_route", r ->r.path("/category")
                        .uri("http://localhost:8015"))
                //商品路由
                .route("product_route", r ->r.path("/product")
                        .uri("http://localhost:8017"))
                .build();
    }*/
}
