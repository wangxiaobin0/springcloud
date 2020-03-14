package com.cloud.controller;

import com.cloud.entity.CommonResult;
import com.cloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author
 * @date 2020/3/6
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    //public static final String SERVER_NAME = "http://CLOUD-PAYMENT-SERVICE";
    public static final String SERVER_NAME = "http://cloud-payment-service";
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/payment")
    public CommonResult<Payment> paymentCommonResult() {
        return restTemplate.getForObject(SERVER_NAME + "/provider/payment/consul", CommonResult.class);
    }
}
