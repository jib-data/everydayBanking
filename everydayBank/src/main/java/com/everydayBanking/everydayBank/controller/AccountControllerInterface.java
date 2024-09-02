package com.everydayBanking.everydayBank.controller;

import com.everydayBanking.everydayBank.model.Account;
import com.everydayBanking.everydayBank.model.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface AccountControllerInterface {
    Account createAccount(@RequestBody Customer customer);
    Account updateAccount(@PathVariable int accountId);
    Account deleteAccount(@PathVariable int accountId);
}
