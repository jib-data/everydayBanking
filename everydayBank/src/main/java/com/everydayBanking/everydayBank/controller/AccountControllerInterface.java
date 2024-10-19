package com.everydayBanking.everydayBank.controller;

import com.everydayBanking.everydayBank.model.Account;
import com.everydayBanking.everydayBank.model.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AccountControllerInterface {
    Account createAccount(int customerId);
    Account updateAccount(int accountId, String type);
    Account deleteAccount(int accountId);
    List<Account> getAllAccounts(int customerId);
}
