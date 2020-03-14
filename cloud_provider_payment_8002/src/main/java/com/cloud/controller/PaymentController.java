package com.cloud.controller;

import com.cloud.entity.CommonResult;
import com.cloud.entity.Payment;
import com.cloud.service.IPaymentService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author
 * @date 2020/3/5
 */
@RestController
@Slf4j
@RequestMapping("/provider")
public class PaymentController {
    @Autowired
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 注入DiscoveryClient实例
     */
    @Autowired
    DiscoveryClient discoveryClient;
    @PostMapping("/payment")
    public CommonResult post(@RequestBody Payment payment) {
        int result = paymentService.post(payment);
        log.info("新增结果..." + result);
        if (result > 0) {
            return new CommonResult(200, "新增成功. serverPort : " + serverPort, result);
        } else {
            return new CommonResult(500, "新增失败", null);
        }
    }

    @GetMapping("/payment/{payId}")
    public CommonResult getPaymentById(@PathVariable("payId") Long payId) {
        Payment payment = paymentService.getPaymentById(payId);
        log.info("查询订单..." + payment);
        if (StringUtils.isEmpty(payment)) {
            return new CommonResult(404, "该订单不存在", null);
        } else {
            return new CommonResult(200, "查询成功. serverPort : " + serverPort, payment);
        }
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
    @GetMapping("/lb")
    public String getLBServerPort() {
        return this.serverPort;
    }
    @GetMapping("/timeout")
    public String getTimeOut() throws InterruptedException {
        Thread.sleep(3000);
        return this.serverPort;
    }
}
