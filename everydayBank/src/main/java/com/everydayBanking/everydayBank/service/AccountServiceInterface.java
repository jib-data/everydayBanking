package com.everydayBanking.everydayBank.service;

import com.everydayBanking.everydayBank.model.Account;
import com.everydayBanking.everydayBank.model.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AccountServiceInterface {
    Account createAccount(@RequestBody Customer customer);
    Account getAccountById(@PathVariable int accountId);
    List<Account> getCustomerAccountById(@PathVariable int customerId);
    Account deleteAccountById(@PathVariable int accountId);
    Account updateAccountByAccountId(@PathVariable int accountId);
}
