package com.umsss.users.application.service;

import com.umsss.users.application.exception.AccountNotFoundException;
import com.umsss.users.application.model.domain.Account;
import com.umsss.users.application.model.repository.AccountRepository;
import org.springframework.stereotype.Service;

/**
 * @author Santiago Mamani
 */
@Service
public class AccountReadByEmailService extends AbstractReadAccountService {

    private String email;

    @Override
    protected Account findAccount(AccountRepository repository) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new AccountNotFoundException("Not exist account for email: " + email));
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
