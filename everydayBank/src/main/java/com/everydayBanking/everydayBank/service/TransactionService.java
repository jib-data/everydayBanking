package com.everydayBanking.everydayBank.service;


import com.everydayBanking.everydayBank.model.Account;
import com.everydayBanking.everydayBank.model.Transaction;
import com.everydayBanking.everydayBank.model.TransactionType;
import com.everydayBanking.everydayBank.repository.AccountRepository;
import com.everydayBanking.everydayBank.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TransactionService implements TransactionServiceInterface{
    AccountService accountService;
    TransactionRepository transactionRepository;

    public TransactionService() {
    }
    @Autowired
    public TransactionService(AccountService accountService, TransactionRepository transactionRepository) {
        this.accountService = accountService;
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional
    public boolean depositMoney(int accountId, int amountDeposited) {
        Account userAccount = accountService.getAccountById(accountId);
        if (userAccount != null){
            userAccount.setAccountBalance(userAccount.getAccountBalance() + amountDeposited);
            saveTransactionObject(userAccount, amountDeposited);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean withdrawMoney(int accountId, int amountWithdrawn) {
        Account userAccount = accountService.getAccountById(accountId);
        if (userAccount != null){
            userAccount.setAccountBalance(userAccount.getAccountBalance() - amountWithdrawn);
            saveTransactionObject(userAccount, amountWithdrawn);
            return true;
        }
        return false;
    }

    @Override
    public Transaction transferMoney(int senderAccountId, int receiverAccountId, int amountTransferred) {
        return null;
    }

    private void saveTransactionObject(Account userAccount, int transactionAmount) {
        Transaction transaction = new Transaction(userAccount.getAccountId(), TransactionType.DEPOSIT, transactionAmount, LocalDateTime.now());
        transactionRepository.save(transaction);
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
