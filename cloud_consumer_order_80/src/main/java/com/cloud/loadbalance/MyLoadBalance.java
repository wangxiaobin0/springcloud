package com.cloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author
 * @date 2020/3/6
 */
public interface MyLoadBalance {
    /**
     * 注入服务实例
     * @param serviceInstanceList
     */
    void setServiceInstance(List<ServiceInstance> serviceInstanceList);
}
