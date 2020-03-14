package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * @date 2020/3/6
 */
@Configuration
public class LoadBalanceRule {

    @Bean
    public IRule myLoadBalanceRule() {
        return new RandomRule();
    }
}
