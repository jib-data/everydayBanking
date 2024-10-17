package com.everydayBanking.everydayBank.service;

import com.everydayBanking.everydayBank.model.Transaction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TransactionServiceInterface {
    boolean depositMoney(int accountId, Double amountDeposited);
    boolean withdrawMoney(int accountId, Double amountWithdrawn);
    boolean transferMoney(int senderAccountId,int receiverAccountId, Double amountTransferred);
    Transaction getTransactionById(int transactionId);
    List<Transaction> getAllTransactionsByAccountId(int accountId);
    Transaction deleteTransactionByTransactionId(int transactionId);
}
