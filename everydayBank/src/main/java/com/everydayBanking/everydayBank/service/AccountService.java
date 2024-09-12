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
    public Account createAccount(Customer customer) {
        return null;
    }

    @Override
    public Account getAccountById(int accountId) {
        return null;
    }

    @Override
    public List<Account> getCustomerAccountsById(int customerId) {

        return null;
    }

    @Override
    public Account deleteAccountById(int accountId) {
        return null;
    }

    @Override
    public Account updateAccountByAccountId(int accountId) {
        return null;
    }
}
