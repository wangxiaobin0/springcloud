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
public class StreamConsumerApplication8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerApplication8802.class, args);
    }
}
