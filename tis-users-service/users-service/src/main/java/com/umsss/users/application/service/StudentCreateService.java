package com.umsss.users.application.service;

import com.umsss.users.api.input.StudentInput;
import com.umsss.users.api.model.AccountState;
import com.umsss.users.application.model.domain.Account;
import com.umsss.users.application.model.domain.Student;
import com.umsss.users.application.model.repository.AccountRepository;
import com.umsss.users.application.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Santiago Mamani
 */
@Service
public class StudentCreateService {

    private StudentInput input;

    private Student student;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private StudentRepository studentsRepository;

    public void execute() {
        Account account = createInstanceAccount();

        account = accountRepository.save(account);

        Student instance = createInstanceStudent(account);

        student = studentsRepository.save(instance);
    }

    private Account createInstanceAccount() {
        Account account = new Account();
        account.setEmail(input.getEmail());
        account.setState(AccountState.ACTIVATED);
        account.setCreatedDate(new Date());

        return account;
    }

    private Student createInstanceStudent(Account account) {
        Student studentInstance = new Student();
        studentInstance.setFirstName(input.getFirstName());
        studentInstance.setLastName(input.getLastName());
        studentInstance.setPassword(input.getPassword());
        studentInstance.setActive(Boolean.TRUE);
        studentInstance.setCreatedDate(new Date());
        studentInstance.setAccount(account);

        return studentInstance;
    }

    public void setInput(StudentInput input) {
        this.input = input;
    }

    public Student getStudent() {
        return student;
    }
}
