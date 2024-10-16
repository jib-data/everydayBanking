package com.everydayBanking.everydayBank.service;

import com.everydayBanking.everydayBank.model.Transaction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TransactionServiceInterface {
    boolean depositMoney(@RequestParam int accountId, @RequestParam int amountDeposited);
    boolean withdrawMoney(@RequestParam int accountId, @RequestParam int amountWithdrawn);
    Transaction transferMoney(@RequestParam int senderAccountId, @RequestParam int receiverAccountId, @PathVariable int amountTransferred);
    Transaction getTransactionById(@PathVariable int transactionId);
    List<Transaction> getAllTransactionsByAccountId(@PathVariable int accountId);
    Transaction deleteTransactionByTransactionId(@PathVariable int transactionId);
}
