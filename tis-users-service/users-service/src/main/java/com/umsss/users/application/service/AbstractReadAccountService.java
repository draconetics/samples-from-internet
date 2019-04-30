package com.umsss.users.application.service;

import com.umsss.users.application.model.domain.Account;
import com.umsss.users.application.model.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Santiago Mamani
 */
abstract class AbstractReadAccountService {

    private Account account;

    @Autowired
    private AccountRepository repository;

    public void execute() {
        account = findAccount(repository);
    }

    protected abstract Account findAccount(AccountRepository repository);

    public Account getAccount() {
        return account;
    }
}
