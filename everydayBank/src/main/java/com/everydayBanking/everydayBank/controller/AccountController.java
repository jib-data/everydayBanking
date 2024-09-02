package com.everydayBanking.everydayBank.controller;


import com.everydayBanking.everydayBank.model.Account;
import com.everydayBanking.everydayBank.model.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController implements AccountControllerInterface{


    @Override
    public Account createAccount(@RequestBody Customer customer) {
        return null;
    }

    @Override
    public Account updateAccount(@PathVariable int accountId) {
        return null;
    }

    @Override
    public Account deleteAccount(@PathVariable int accountId) {
        return null;
    }
}
