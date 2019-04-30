package com.umsss.users.application.service;

import com.umsss.users.api.input.AccountInput;
import com.umsss.users.api.model.AccountState;
import com.umsss.users.application.model.domain.Account;
import com.umsss.users.application.model.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Santiago Mamani
 */
@Service
public class AccountUpdateService {

    private Long accountId;

    private AccountInput input;

    private Account account;

    @Autowired
    private AccountRepository repository;

    public void execute() {
        account = findAccount(accountId);

        if (null != account) {
            updateAccount(account);
            account = repository.save(account);
        }
    }

    private Account findAccount(Long accountId) {
        return repository.findById(accountId).orElse(null);
    }

    private void updateAccount(Account account) {
        account.setEmail(input.getEmail());
        account.setState(AccountState.ACTIVATED);
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setInput(AccountInput input) {
        this.input = input;
    }

    public Account getAccount() {
        return account;
    }
}
