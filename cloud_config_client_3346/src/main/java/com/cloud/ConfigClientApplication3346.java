package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author
 * @date 2020/3/8
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApplication3346 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication3346.class, args);
    }
}
