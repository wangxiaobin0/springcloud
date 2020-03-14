package com.cloud.controller;

import com.cloud.service.IPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author
 * @date 2020/3/7
 */
@RestController
@RequestMapping("/order/hystrix")
//@DefaultProperties(defaultFallback = "fallback")
public class OrderController {

    @Resource
    IPaymentService paymentService;

    @GetMapping("/ok/{id}")
    //@HystrixCommand
    public String getOk(@PathVariable("id") Long id) {
        return paymentService.getOk(id);
    }

    @GetMapping("/timeout/{id}")
    //@HystrixCommand(
            //commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")}
    //)
    public String getTimeout(@PathVariable("id") Long id) {
        return paymentService.getTimeout(id);
    }

    String fallback() {
        return "服务调用方调用服务失败, 主动服务降级";
    }
    @GetMapping("/circuitbreaker/{id}")
    //@HystrixCommand(
    //commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")}
    //)
    public String circuitbreaker(@PathVariable("id") Long id) {
        return paymentService.circuitbreaker(id);
    }
}
