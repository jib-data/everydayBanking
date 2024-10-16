package com.everydayBanking.everydayBank.service;

import com.everydayBanking.everydayBank.model.Transaction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TransactionServiceInterface {
    Transaction depositMoney(int accountId, Long amountDeposited);
    Transaction withdrawMoney(int accountId, int amountWithdrawn);
    Transaction transferMoney(int senderAccountId,int receiverAccountId, int amountTransferred);
    Transaction getTransactionById(int transactionId);
    List<Transaction> getAllTransactionsByAccountId(int accountId);
    Transaction deleteTransactionByTransactionId(int transactionId);
}
