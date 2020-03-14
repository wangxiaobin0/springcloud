package com.cloud.service.impl;

import com.cloud.service.IPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author
 * @date 2020/3/7
 */
@Service
@Slf4j
public class PaymentServiceImpl implements IPaymentService {

    @Value("${server.port}")
    String serverPort;

    @Override
    @HystrixCommand(defaultFallback = "fallback")
    public String getOk(Long id) {
        if (id == 1) {
            int i = 1 / 0;
        }
        String result = Thread.currentThread().getName() + "\tgetOk()\t" + "\t端口:\t" + serverPort + "\t" + id;
        log.info(result);
        return result;
    }

    @Override
    @HystrixCommand(defaultFallback = "fallback",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")}
    )
    public String getTimeout(Long id) {
        int time = 3000;
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = Thread.currentThread().getName() + "\tgetTimeout()\t" + "\t端口:\t" + serverPort + "\t" + id;
        log.info(result);
        return result;
    }

    public String fallback() {
        String result = Thread.currentThread().getName() + "\t端口:\t" + serverPort + "\t服务调用失败";
        log.info(result);
        return result;
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "circuitBreakerFallback",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //熔断机制开关, 默认开启
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
            }
    )
    public String testCircuitBreaker(Long id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数" + id);
        }
        String result = Thread.currentThread().getName() + "\ttestCircuitBreaker()\t" + "\t端口:\t" + serverPort + "\t" + id;
        log.info(result);
        return result;
    }

    public String circuitBreakerFallback(Long id) {
        String result = "id不能为负数" + id;
        log.info(result);
        return result;
    }
}
