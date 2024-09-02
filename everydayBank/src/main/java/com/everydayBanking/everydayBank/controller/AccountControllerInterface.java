package com.everydayBanking.everydayBank.controller;

import com.everydayBanking.everydayBank.model.Account;
import com.everydayBanking.everydayBank.model.Customer;
import org.springframework.web.bind.annotation.RequestBody;

public interface AccountControllerInterface {
    Account createAccount(@RequestBody Customer customer);
    Account updateAccount(int accountId);
    Account deleteAccount(int accountId);
}
