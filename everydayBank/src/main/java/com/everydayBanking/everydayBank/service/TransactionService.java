package com.everydayBanking.everydayBank.service;


import com.everydayBanking.everydayBank.model.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TransactionService implements TransactionServiceInterface{
    @Override
    public Transaction depositMoney(int accountId, int amountDeposited) {
        return null;
    }

    @Override
    public Transaction withdrawMoney(int accountId, int amountWithdrawn) {
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
