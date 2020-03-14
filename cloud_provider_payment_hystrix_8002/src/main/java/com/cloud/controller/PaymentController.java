package com.cloud.controller;

import com.cloud.service.IPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @date 2020/3/7
 */
@RestController
@RequestMapping("/provider/hystrix")
public class PaymentController {

    @Autowired
    IPaymentService paymentService;

    @GetMapping("/ok/{id}")
    public String getOk(@PathVariable("id") Long id) {
        return paymentService.getOk(id);
    }


    @GetMapping("/timeout/{id}")
    public String getTimeout(@PathVariable("id") Long id){
        return paymentService.getTimeout(id);
    }

    @GetMapping("/circuitbreaker/{id}")
    public String testCircuitBreaker(@PathVariable("id") Long id){
        return paymentService.testCircuitBreaker(id);
    }

}
