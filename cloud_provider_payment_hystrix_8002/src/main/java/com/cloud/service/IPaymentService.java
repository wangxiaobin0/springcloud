package com.cloud.service;

/**
 * @author
 * @date 2020/3/7
 */
public interface IPaymentService {

    /**
     * 正常测试
     * @param id
     * @return
     */
    String getOk(Long id);

    /**
     * 超时测试
     * @param id
     * @return
     */
    String getTimeout(Long id);
    public String testCircuitBreaker(Long id);

}
