package com.umsss.users.application.config;

import feign.codec.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Santiago Mamani
 */
@Configuration
public class FeignConfig {

    @Bean
    public Encoder feignEncoder() {
        return new FeignSpringFormEncoder();
    }
}
