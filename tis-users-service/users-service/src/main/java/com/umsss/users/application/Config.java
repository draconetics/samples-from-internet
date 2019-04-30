package com.umsss.users.application;

import com.umsss.users.application.model.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean(name = "test1")
    public Test testBean1() {
        return new Test();
    }
}
