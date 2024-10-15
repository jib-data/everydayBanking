package com.everydayBanking.everydayBank.service;


import com.everydayBanking.everydayBank.controller.AccountControllerInterface;
import com.everydayBanking.everydayBank.model.Account;
import com.everydayBanking.everydayBank.model.Customer;
import com.everydayBanking.everydayBank.repository.AccountRepository;
import com.everydayBanking.everydayBank.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AccountService implements AccountServiceInterface {
     AccountRepository accountRepository;

     private static final String ACCOUNT_INITIAL = "AB";
     private static final AtomicLong AccountDigits = new AtomicLong();
    private final CustomerRepository customerRepository;



    @Autowired
    public AccountService(AccountRepository accountRepository,
                          CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    public Account createAccount(Customer customer) {
        String accountNumber = createAccountNumber();
        Account newAccount = new Account();
//        newAccount.setCustomer(customer);
        newAccount.setAccountNumber(accountNumber);
        newAccount.setAccountBalance(0.0);
        newAccount.setCreation(LocalDateTime.now());
        customer.addAccounts(newAccount);
        return newAccount;
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
        return accountRepository.findByCustomerId(customerId);
    }

    @Override
    @Transactional
    public Account deleteAccountById(int accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if(account.isPresent()){
            Account deletedAccount = account.get();
            Customer customer = deletedAccount.getCustomer();
            if (customer.getAccounts().size() == 1){
//                accountRepository.deleteById(deletedAccount.getAccountId());
                customerRepository.deleteById(customer.getCustomerId());
            } else {
                accountRepository.deleteById(deletedAccount.getAccountId());
            }

            return deletedAccount;
        }
        return null;

    }

    @Override
    public Account updateAccountByAccountId(int accountId, String type) {
        Optional<Account> updatedAccount = accountRepository.findById(accountId);
        if (updatedAccount.isPresent()){
            updatedAccount.get().setAccountType(type);
            return updatedAccount.get();
        }
        return null;
    }

    public String createAccountNumber(){
        setCurrentAccountNumber(accountRepository);
        Long currentAccountDigit = AccountDigits.incrementAndGet();
        String formattedDigits = String.format("%09d", currentAccountDigit);
        String accountNumber = ACCOUNT_INITIAL + formattedDigits;
        return accountNumber;

    }
    public static void setCurrentAccountNumber(AccountRepository accountRepository){
        Optional<Account> lastAccount = accountRepository.findTopByOrderByAccountIdDesc();
        if (lastAccount.isPresent()){
            String lastAccountNumber = lastAccount.get().getAccountNumber();
            try {
                Long lastNumber = Long.parseLong(lastAccountNumber.replace(ACCOUNT_INITIAL, ""));
                AccountDigits.set(lastNumber);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                AccountDigits.set(0l);
            }

        } else {
            AccountDigits.set(0l);
        }
    }
}
