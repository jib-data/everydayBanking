package com.everydayBanking.everydayBank.controller;


import com.everydayBanking.everydayBank.model.Account;
import com.everydayBanking.everydayBank.model.Customer;
import com.everydayBanking.everydayBank.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/account")
public class AccountController implements AccountControllerInterface{
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @Override
    @PostMapping("/create")
    public Account createAccount(@PathVariable int customerId) {
        return accountService.createAccount(customerId);
    }

    @Override
    @PatchMapping("/update")
    public Account updateAccount(@PathVariable int accountId, String type) {
        return accountService.updateAccountByAccountId(accountId, type);
    }

    @Override
    @DeleteMapping("/delete")
    public Account deleteAccount(@PathVariable int accountId) {
        return accountService.deleteAccountById(accountId);
    }
    @Override
    @GetMapping("/accounts")
    public List<Account> getAllAccounts(int customerId){
        return accountService.getCustomerAccountsById(customerId);
    }
}
