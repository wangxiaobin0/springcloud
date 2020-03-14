package com.cloud.controller;

import cn.hutool.core.lang.UUID;
import com.cloud.entity.CommonResult;
import com.cloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author
 * @date 2020/3/6
 */
@RestController
@Slf4j
@RequestMapping("/provider")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @Autowired
    DiscoveryClient discoveryClient;
    @GetMapping("/payment/zk")
    public CommonResult<Payment> getPaymentById() {
        return new CommonResult<Payment>(200, serverPort + " : 查询成功...", new Payment(1, UUID.randomUUID().toString()));
    }

    @GetMapping("/discovery")
    public Object discoveryClient() {
        log.info("查询注册中心的所有服务");
        List<String> services = discoveryClient.getServices();
        for (String serviceName : services) {
            log.info(serviceName);
        }
        String serviceId = "CLOUD-PAYMENT-SERVICE";
        log.info("查询所有实例 : " + serviceId);
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort());
        }
        return discoveryClient;
    }
}
