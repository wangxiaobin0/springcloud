package com.cloud.service;

import com.cloud.entity.CommonResult;
import com.cloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 * @date 2020/3/7
 */
@FeignClient("cloud-payment-service")
@RequestMapping("/provider")
public interface IPaymentService {

    /**
     * 根据id获取订单
     *
     * @param payId
     * @return
     */
    @GetMapping("/payment/{payId}")
    CommonResult<Payment> get(@PathVariable("payId") Long payId);

    /**
     * 新增订单
     *
     * @param payment
     * @return
     */
    @PostMapping("/payment")
    CommonResult post(@RequestBody Payment payment);


    /**
     *
     * @return
     */
    @GetMapping("/discovery")
    Object getDis();

    /**
     * 测试超时
     * @return
     */
    @GetMapping("/timeout")
    String getTimeOut();
}
