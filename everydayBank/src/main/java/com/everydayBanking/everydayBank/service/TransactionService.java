package com.everydayBanking.everydayBank.service;


import com.everydayBanking.everydayBank.model.Account;
import com.everydayBanking.everydayBank.model.Transaction;
import com.everydayBanking.everydayBank.model.TransactionType;
import com.everydayBanking.everydayBank.repository.AccountRepository;
import com.everydayBanking.everydayBank.repository.TransactionRepository;
//import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TransactionService implements TransactionServiceInterface{
    AccountService accountService;
    TransactionRepository transactionRepository;
    AccountRepository accountRepository;

    public TransactionService() {
    }
    @Autowired
    public TransactionService(AccountService accountService, TransactionRepository transactionRepository,
                              AccountRepository accountRepository) {
        this.accountService = accountService;
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public Transaction depositMoney(int accountId, Long amountDeposited) {
        Account account = accountService.getAccountById(accountId);
        if (account != null){
            account.setAccountBalance(account.getAccountBalance() + amountDeposited);
            accountRepository.save(account);
            saveTransactionObject(account, amountDeposited);


        }
        return null;
    }

    private void saveTransactionObject(Account account, Long amount) {
        Transaction transaction = new Transaction(TransactionType.DEPOSIT, amount, LocalDateTime.now(), account);
        transactionRepository.save(transaction);
    }

    @Override
    @Transactional
    public Transaction withdrawMoney(int accountId, Long amountWithdrawn) {
        Account account = accountService.getAccountById(accountId);
        if (account != null){
            account.setAccountBalance(account.getAccountBalance() + amountWithdrawn);
            accountRepository.save(account);
            saveTransactionObject(account, amountWithdrawn);
        }
        return null;
    }

    @Override
    public Transaction transferMoney(int senderAccountId, int receiverAccountId, int amountTransferred) {
        return null;
    }

    @Override
    public Transaction getTransactionById(int transactionId) {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactionsByAccountId(int accountId) {
        return List.of();
    }

    @Override
    public Transaction deleteTransactionByTransactionId(int transactionId) {
        return null;
    }
}
