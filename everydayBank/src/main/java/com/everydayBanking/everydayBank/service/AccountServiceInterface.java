package com.everydayBanking.everydayBank.service;

import com.everydayBanking.everydayBank.model.Account;
import com.everydayBanking.everydayBank.model.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AccountServiceInterface {
    Account createAccount(Customer customer);
    Account getAccountById(int accountId);
    List<Account> getCustomerAccountsById(int customerId);
    Account deleteAccountById(int accountId);
    Account updateAccountByAccountId(int accountId);
}
