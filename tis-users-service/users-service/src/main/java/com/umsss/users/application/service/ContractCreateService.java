package com.umsss.users.application.service;

import com.umsss.users.api.input.ContractInput;
import com.umsss.users.application.exception.UserNotFoundException;
import com.umsss.users.application.model.domain.Contract;
import com.umsss.users.application.model.domain.Teacher;
import com.umsss.users.application.model.repository.ContractRepository;
import com.umsss.users.application.model.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Santiago Mamani
 */
@Service
public class ContractCreateService {

    private ContractInput input;

    private Contract contract;

    @Autowired
    private ContractRepository repository;

    @Autowired
    private TeacherRepository teacherRepository;

    public void execute() {
        Teacher teacher = findTeacher();

        contract = repository.save(composeContractInstance(teacher));
    }

    private Contract composeContractInstance(Teacher teacher) {
        Contract contractInstance = new Contract();
        contractInstance.setInitDate(input.getInitDate());
        contractInstance.setEndDate(input.getEndDate());
        contractInstance.setSalary(input.getSalary());
        contractInstance.setTeacher(teacher);

        return contractInstance;
    }

    private Teacher findTeacher() {
        return teacherRepository.findById(input.getTeacherId())
                .orElseThrow(() -> new UserNotFoundException("Unable locate teacher to teacherId: " + input.getTeacherId()));
    }

    public void setInput(ContractInput input) {
        this.input = input;
    }

    public Contract getContract() {
        return contract;
    }
}
