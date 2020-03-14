package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author
 * @date 2020/3/9
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamProviderApplication8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamProviderApplication8801.class, args);
    }
}
