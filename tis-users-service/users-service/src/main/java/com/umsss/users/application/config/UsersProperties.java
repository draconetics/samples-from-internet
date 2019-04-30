package com.umsss.users.application.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Santiago Mamani
 */
@Configuration
@PropertySource("classpath:/version/api-version.properties")
public class UsersProperties {

    @Value("${users.account.status:ACTIVATED_ALLOWED}")
    private String accountStatus;
    @Value("${users.version:0.0.2}")
    private String version;

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
