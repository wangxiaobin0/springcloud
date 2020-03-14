package com.cloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author
 * @date 2020/3/6
 */
@Component
public class RoundRobinLoadBalance implements MyLoadBalance {

    private List<ServiceInstance> serviceInstanceList;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 注入服务实例
     * @param serviceInstanceList
     */
    @Override
    public void setServiceInstance(List<ServiceInstance> serviceInstanceList) {
        this.serviceInstanceList = serviceInstanceList;
    }

    /**
     * 获取目标服务实例
     * @return
     */
    public ServiceInstance serviceInstance() {
        //获取服务实例索引
        int next = getAndSetNext();
        int total = serviceInstanceList.size();
        //返回服务实例
        return serviceInstanceList.get(next % total);
    }

    /**
     * 获取服务实例索引
     * @return
     */
    public final int getAndSetNext() {
        int current;
        int next;
        do {
            //获取期望值
            current = this.atomicInteger.get();
            //获取更新值
            next = current + 1;
            //如果CAS不成立就继续循环
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("第" + next + "次请求");
        return next;
    }
}
