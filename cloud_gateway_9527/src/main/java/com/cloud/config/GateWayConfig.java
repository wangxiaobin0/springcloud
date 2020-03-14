package com.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * @date 2020/3/8
 */
@Configuration
public class GateWayConfig {

    @Bean
    RouteLocator routeLocator1(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("baiduNews1", r->(r.path("/guoji").uri("http://news.baidu.com")))
                .route("baiduNews2", r->(r.path("/guonei").uri("http://news.baidu.com")));
        return routes.build();
    }
}
