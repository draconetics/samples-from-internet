package com.umsss.users.application.service;

import com.umsss.users.api.input.TeacherInput;
import com.umsss.users.api.model.AccountState;
import com.umsss.users.application.model.domain.Account;
import com.umsss.users.application.model.domain.Teacher;
import com.umsss.users.application.model.repository.AccountRepository;
import com.umsss.users.application.model.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Santiago Mamani
 */
@Service
public class TeacherCreateService {
    private TeacherInput input;

    private Teacher teacher;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public void execute() {
        Account account = createInstanceAccount();

        account = accountRepository.save(account);

        Teacher instance = createInstanceTeacher(account);

        teacher = teacherRepository.save(instance);
    }

    private Account createInstanceAccount() {
        Account account = new Account();
        account.setEmail(input.getEmail());
        account.setState(AccountState.ACTIVATED);
        account.setCreatedDate(new Date());

        return account;
    }

    private Teacher createInstanceTeacher(Account account) {
        Teacher teacherInstance = new Teacher();
        teacherInstance.setFirstName(input.getFirstName());
        teacherInstance.setLastName(input.getLastName());
        teacherInstance.setProfession(input.getProfession());
        teacherInstance.setPassword(input.getPassword());
        teacherInstance.setActive(Boolean.TRUE);
        teacherInstance.setCreatedDate(new Date());
        teacherInstance.setAccount(account);

        return teacherInstance;
    }

    public void setInput(TeacherInput input) {
        this.input = input;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
