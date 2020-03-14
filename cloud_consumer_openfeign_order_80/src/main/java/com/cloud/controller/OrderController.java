package com.cloud.controller;

import com.cloud.entity.CommonResult;
import com.cloud.entity.Payment;
import com.cloud.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 * @date 2020/3/7
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    IPaymentService paymentService;
    @GetMapping("/payment/{id}")
    public CommonResult<Payment> paymentCommonResult(@PathVariable("id") Long id) {
        CommonResult<Payment> paymentCommonResult = paymentService.get(id);
        return paymentCommonResult;
    }

    @PostMapping("/payment")
    public CommonResult post(@RequestBody Payment payment) {
        CommonResult post = paymentService.post(payment);
        return post;
    }

    @GetMapping("/discovery")
    public Object getDis() {
        Object dis = paymentService.getDis();
        return dis;
    }

    @GetMapping("/timeout")
    public String getTimeOut() throws InterruptedException {
        return paymentService.getTimeOut();
    }
}
