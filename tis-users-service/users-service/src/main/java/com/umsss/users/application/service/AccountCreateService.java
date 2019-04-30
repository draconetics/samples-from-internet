package com.umsss.users.application.service;

import com.umsss.users.api.input.AccountInput;
import com.umsss.users.api.model.AccountState;
import com.umsss.users.application.config.UsersEnvironment;
import com.umsss.users.application.config.UsersProperties;
import com.umsss.users.application.model.domain.Account;
import com.umsss.users.application.model.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Santiago Mamani
 */
@Service
public class AccountCreateService {

    private static Logger LOG = LoggerFactory.getLogger(AccountCreateService.class);

    private AccountInput input;

    private Account account;

    @Autowired
    private UsersProperties usersProperties;

    @Autowired
    private UsersEnvironment usersEnvironment;

    @Autowired
    private AccountRepository repository;

    public void execute() {

        LOG.info("value api version: {}", usersProperties.getVersion());
        LOG.info("name users tis: {}", usersEnvironment.getNameUsersTis());

        Account instance = composeAccount();

        account = repository.save(instance);
    }

    private Account composeAccount() {
        AccountState accountState = AccountState.DEACTIVATED;
        String accountStatusProperties = usersProperties.getAccountStatus();
        if (accountStatusProperties.equals("ACTIVATED_ALLOWED")) {
            accountState = AccountState.ACTIVATED;
        }
        Account instance = new Account();
        instance.setEmail(input.getEmail());
        instance.setState(accountState);
        instance.setCreatedDate(new Date());

        return instance;
    }

    public void setInput(AccountInput input) {
        this.input = input;
    }

    public Account getAccount() {
        return account;
    }
}
