package com.everydayBanking.everydayBank.service;


import com.everydayBanking.everydayBank.controller.AccountControllerInterface;
import com.everydayBanking.everydayBank.model.Account;
import com.everydayBanking.everydayBank.model.Customer;
import com.everydayBanking.everydayBank.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AccountService implements AccountServiceInterface {
     AccountRepository accountRepository;

    public AccountService() {
    }

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(@RequestBody Customer customer) {
        return null;
    }

    @Override
    public Account getAccountById(@PathVariable int accountId) {
        return null;
    }

    @Override
    public List<Account> getCustomerAccountById(@PathVariable int customerId) {
        return List.of();
    }

    @Override
    public Account deleteAccountById(@PathVariable int accountId) {
        return null;
    }

    @Override
    public Account updateAccountByAccountId(@PathVariable int accountId) {
        return null;
    }
}
