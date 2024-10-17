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
    public boolean depositMoney(int accountId, Double amountDeposited) {
        Account account = accountService.getAccountById(accountId);
        if (account != null){
            account.setAccountBalance(account.getAccountBalance() + amountDeposited);
            accountRepository.save(account);
            saveTransactionObject(account, amountDeposited, TransactionType.DEPOSIT);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean withdrawMoney(int accountId, Double amountWithdrawn) {
        Account account = accountService.getAccountById(accountId);
        if (account != null){
            if (account.getAccountBalance() - amountWithdrawn >= 0){
                account.setAccountBalance(account.getAccountBalance() - amountWithdrawn);
                accountRepository.save(account);
                saveTransactionObject(account, amountWithdrawn, TransactionType.WITHDRAWAL);
                return true;
            }
        }
        return false;
    }

    @Override
    @Transactional
    public boolean transferMoney(int senderAccountId, int receiverAccountId, Double amountTransferred) {
        Account senderAccount = accountService.getAccountById(senderAccountId);
        Account receiverAccount = accountService.getAccountById(receiverAccountId);
        if(senderAccount != null && receiverAccount != null){
            if (senderAccount.getAccountBalance() - amountTransferred >= 0){
                senderAccount.setAccountBalance(senderAccount.getAccountBalance() - amountTransferred);
                receiverAccount.setAccountBalance(receiverAccount.getAccountBalance()+ amountTransferred);
                accountRepository.save(senderAccount);
                accountRepository.save(receiverAccount);
                saveTransactionObject(senderAccount, amountTransferred, TransactionType.TRANSFER);
                return true;
            }
        }

        return false;
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
    private void saveTransactionObject(Account account, Double amount, TransactionType transactionType) {
        Transaction transaction = new Transaction(transactionType, amount, LocalDateTime.now(), account);
        transactionRepository.save(transaction);
    }
}
