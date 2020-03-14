package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author
 * @date 2020/3/8
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApplication3345 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication3345.class, args);
    }
}
