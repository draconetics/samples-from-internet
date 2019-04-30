package com.umsss.users.application.controller;

import com.umsss.users.api.input.ContractInput;
import com.umsss.users.application.model.domain.Contract;
import com.umsss.users.application.service.ContractCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Santiago Mamani
 */
@RequestMapping(value = Constants.BasePath.CONTRACTS)
@RestController
@RequestScope
public class ContractController {

    @Autowired
    private ContractCreateService contractCreateService;

    @RequestMapping(method = RequestMethod.POST)
    public Contract createContract(@RequestBody ContractInput input) {

        contractCreateService.setInput(input);
        contractCreateService.execute();

        return contractCreateService.getContract();
    }
}
