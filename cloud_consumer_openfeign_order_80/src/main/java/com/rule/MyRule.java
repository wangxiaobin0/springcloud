package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * @date 2020/3/7
 */
@Configuration
public class MyRule {
    @Bean
    IRule getMyRule() {
        return new RandomRule();
    }
}
