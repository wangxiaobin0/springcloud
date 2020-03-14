package com.cloud.service.impl;

import com.cloud.service.IPaymentService;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date 2020/3/7
 */
@Component
public class PaymentServiceImpl implements IPaymentService {
    @Override
    public String getOk(Long id) {
        String result = Thread.currentThread().getName() + "\tgetOk()调用失败\t";
        return result;
    }

    @Override
    public String getTimeout(Long id) {
        String result = Thread.currentThread().getName() + "\tgetTimeout()调用失败\t";
        return result;
    }

    @Override
    public String circuitbreaker(Long id) {
        String result = Thread.currentThread().getName() + "\tcircuitbreaker()调用失败\t";
        return result;
    }
}
