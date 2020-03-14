package com.cloud.service;

import com.cloud.service.impl.PaymentServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author
 * @date 2020/3/7
 */
@FeignClient(value = "cloud-payment-hystrix-service", fallback = PaymentServiceImpl.class)
public interface IPaymentService {
    /**
     * ok接口
     * @param id
     * @return
     */
    @GetMapping("/provider/hystrix/ok/{id}")
    String getOk(@PathVariable("id") Long id);

    /**
     * timeout接口
     * @param id
     * @return
     */
    @GetMapping("/provider/hystrix/timeout/{id}")
    String getTimeout(@PathVariable("id") Long id);


    /**
     * ds
     * @param id
     * @return
     */
    @GetMapping("/provider/hystrix/circuitbreaker/{id}")
    String circuitbreaker(@PathVariable("id") Long id);
}
