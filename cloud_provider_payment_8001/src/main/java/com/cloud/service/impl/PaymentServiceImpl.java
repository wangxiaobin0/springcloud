package com.cloud.service.impl;

import com.cloud.dao.IPaymentDao;
import com.cloud.entity.Payment;
import com.cloud.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author
 * @date 2020/3/5
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    IPaymentDao paymentDao;
    @Override
    public int post(Payment payment) {
        int post = paymentDao.post(payment);
        return post;
    }

    @Override
    public Payment getPaymentById(Long payId) {
        return paymentDao.getPaymentById(payId);
    }
}
