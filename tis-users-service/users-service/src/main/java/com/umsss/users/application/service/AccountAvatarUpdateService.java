package com.umsss.users.application.service;

import com.umsss.users.application.client.binaries.model.Binary;
import com.umsss.users.application.client.binaries.service.SystemBinaryService;
import com.umsss.users.application.exception.AccountNotFoundException;
import com.umsss.users.application.model.domain.Account;
import com.umsss.users.application.model.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Santiago Mamani
 */
@Service
public class AccountAvatarUpdateService {

    private Long accountId;

    private MultipartFile file;

    private Account account;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SystemBinaryService service;

    public void execute() {
        Account instance = findAccount(accountId);

        if (null == instance.getAvatarId()) {
            Binary binary = service.uploadBinary(file);

            instance.setAvatarId(binary.getId());

            account = accountRepository.save(instance);
        }
    }

    private Account findAccount(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Account getAccount() {
        return account;
    }
}
