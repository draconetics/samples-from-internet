package com.umsss.users.application.service;

import com.umsss.users.application.exception.AccountNotFoundException;
import com.umsss.users.application.model.domain.Account;
import com.umsss.users.application.model.repository.AccountRepository;
import org.springframework.stereotype.Service;

/**
 * @author Santiago Mamani
 */
@Service
public class AccountReadByIdService extends AbstractReadAccountService {

    private Long accountId;

    @Override
    protected Account findAccount(AccountRepository repository) {
        return repository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Not exist account for accountId: " + accountId));
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
