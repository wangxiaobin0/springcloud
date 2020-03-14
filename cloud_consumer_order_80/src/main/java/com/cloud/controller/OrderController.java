package com.cloud.controller;

import com.cloud.entity.CommonResult;
import com.cloud.entity.Payment;
import com.cloud.loadbalance.MyLoadBalance;
import com.cloud.loadbalance.RoundRobinLoadBalance;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author
 * @date 2020/3/5
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    public static final String PAYMENT_URL = "http://cloud-payment-service";
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/payment")
    public CommonResult<Payment> post(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/provider/payment", payment, CommonResult.class);
    }

    @GetMapping("/payment/{payId}")
    public CommonResult<Payment> getPaymentById(@PathVariable("payId") Long payId) {
        return restTemplate.getForObject(PAYMENT_URL + "/provider/payment/" + payId, CommonResult.class);
    }

    @GetMapping("/payment/entity/{payId}")
    public CommonResult<Payment> paymentCommonResult(@PathVariable("payId") Long payId) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/provider/payment/" + payId, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult<Payment>(entity.getStatusCode().value(), "查询失败...");
        }
    }

    @Autowired
    RoundRobinLoadBalance loadBalance;
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/lb/{id}")
    public CommonResult<Payment> getLB(@PathVariable("id") Long id) {
        //获取所有服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        //注入所有服务实例
        loadBalance.setServiceInstance(instances);
        //获取服务实例
        ServiceInstance instance = loadBalance.serviceInstance();
        //获取URI
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/provider/payment/" + id, CommonResult.class);
    }
}
