package com.cloud.dao;

import com.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author
 * @date 2020/3/5
 */
@Mapper
public interface IPaymentDao {
    /**
     * 新增订单
     * @param payment
     * @return
     */
    public int post(Payment payment);

    /**
     * 根据id查询订单
     * @param payId
     * @return
     */
    public Payment getPaymentById(@Param("payId") Long payId);
}
