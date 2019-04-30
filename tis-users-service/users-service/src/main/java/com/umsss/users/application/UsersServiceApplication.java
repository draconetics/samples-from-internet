package com.umsss.users.application;

import com.umsss.users.application.model.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class UsersServiceApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(UsersServiceApplication.class, args);

        Test test = (Test) context.getBean("test1");
        test.print();
    }

}

