package com.umsss.users.application.controller;

import com.umsss.users.api.input.AccountInput;
import com.umsss.users.api.model.AccountState;
import com.umsss.users.application.model.Test;
import com.umsss.users.application.model.domain.Account;
import com.umsss.users.application.model.repository.AccountRepository;
import com.umsss.users.application.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api(
        tags = "Rest-account-controller",
        description = "Operations over accounts"
)
@RequestMapping(value = "/accounts")
@RestController
@RequestScope
public class AccountController {

    private Test test;

    @Autowired
    private AccountCreateService accountCreateService;

    @Autowired
    private AccountUpdateService accountUpdateService;

    @Autowired
    private AccountReadByIdService accountReadByIdService;

    @Autowired
    private AccountReadByEmailService accountReadByEmailService;

    @Autowired
    private AccountAvatarUpdateService accountAvatarUpdateService;

    @Autowired
    private AccountRepository repository;

    @Autowired
    public void setTest(Test test) {
        this.test = test;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void testMethod() {
        test.print();
    }

    @ApiOperation(
            value = "Create an account"
    )
    @ApiResponses({
            @ApiResponse(code = 201, message = "Account created"),
            @ApiResponse(code = 404, message = "Not found account")
    })
    @RequestMapping(method = RequestMethod.POST)
    public Account createAccount(@RequestBody AccountInput input) {
        accountCreateService.setInput(input);
        accountCreateService.execute();

        return accountCreateService.getAccount();
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.GET)

    public Account readAccount(@PathVariable("accountId") Long accountId) {
        accountReadByIdService.setAccountId(accountId);
        accountReadByIdService.execute();

        return accountReadByIdService.getAccount();
    }

    @RequestMapping(method = RequestMethod.GET)

    public Account findAccountByEmail(@RequestParam("email") String email) {
        accountReadByEmailService.setEmail(email);
        accountReadByEmailService.execute();

        return accountReadByEmailService.getAccount();
    }

    @RequestMapping(
            value = "/data",
            method = RequestMethod.GET)
    public List<Account> readAccountByEmailAndState(@RequestParam(value = "email", required = false) String email,
                                                    @RequestParam(value = "state") AccountState state) {
        //return repository.findByEmailAndState(email, state);
        return repository.findAccount(email, state);
    }


    @RequestMapping(
            value = "/orderByState",
            method = RequestMethod.GET)
    public List<Account> readAccountByStateOrder(@RequestParam(value = "state") AccountState state) {
        return repository.findByStateOrderByCreatedDateDesc(state);
    }

    @RequestMapping(
            value = "/{accountId}",
            method = RequestMethod.PUT)
    public Account updateAccount(@PathVariable("accountId") Long accountId,
                                 @RequestBody AccountInput input) {
        accountUpdateService.setAccountId(accountId);
        accountUpdateService.setInput(input);
        accountUpdateService.execute();

        return accountUpdateService.getAccount();
    }

    @RequestMapping(
            value = "/{accountId}",
            method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable(value = "accountId") Long accountId) {

        repository.deleteById(accountId);
    }

    @RequestMapping(
            value = "/{accountId}/avatar",
            method = RequestMethod.PUT,
            consumes = "multipart/form-data")
    public Account updateAccountAvatar(@PathVariable(value = "accountId") Long accountId,
                                       @RequestPart(value = "multipartFile") MultipartFile multipartFile) {

        accountAvatarUpdateService.setAccountId(accountId);
        accountAvatarUpdateService.setFile(multipartFile);
        accountAvatarUpdateService.execute();//Ctrl +D

        return accountAvatarUpdateService.getAccount();
    }

}
