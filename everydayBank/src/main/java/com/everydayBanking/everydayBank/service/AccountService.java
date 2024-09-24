package com.everydayBanking.everydayBank.service;


import com.everydayBanking.everydayBank.controller.AccountControllerInterface;
import com.everydayBanking.everydayBank.model.Account;
import com.everydayBanking.everydayBank.model.Customer;
import com.everydayBanking.everydayBank.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements AccountServiceInterface {
     AccountRepository accountRepository;

     private static final String ACCOUNT_INITIAL = "AB";
     private static long AccountDigits = 0;


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
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isPresent()){
            return account.get();
        }
        return null;
    }

    @Override
    public List<Account> getCustomerAccountsById(int customerId) {

        return null;
    }

    @Override
    public Account deleteAccountById(int accountId) {
        Account deletedAccount = deleteAccountById(accountId);
        return deletedAccount;
    }

    @Override
    public Account updateAccountByAccountId(int accountId) {
        return null;
    }

    public String createAccountNumber(){
        Long currentAccountDigit;
        currentAccountDigit = AccountDigits+=1;
        String formattedDigits = String.format("%09d", currentAccountDigit);
        String accountNumber = ACCOUNT_INITIAL + formattedDigits;

        return accountNumber;

    }
}
