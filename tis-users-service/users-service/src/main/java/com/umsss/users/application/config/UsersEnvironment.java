package com.umsss.users.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author Santiago Mamani
 */
@Configuration
public class UsersEnvironment {

    @Autowired
    Environment env;

    public String getNameUsersTis() {
        return env.getProperty("JAVA_HOME");
    }
}
