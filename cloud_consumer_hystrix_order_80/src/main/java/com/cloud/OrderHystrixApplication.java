    package com.cloud;

    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
    import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
    import org.springframework.cloud.openfeign.EnableFeignClients;

    /**
     * @author
     * @date 2020/3/7
     */
    @SpringBootApplication
    @EnableEurekaClient
    @EnableFeignClients
    @EnableCircuitBreaker
    public class OrderHystrixApplication {
        public static void main(String[] args) {
            SpringApplication.run(OrderHystrixApplication.class, args);
        }
    }
