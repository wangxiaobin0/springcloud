package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author
 * @date 2020/3/6
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKApplication.class, args);
    }
}
