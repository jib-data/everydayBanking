package com.everydayBanking.everydayBank.controller;

import com.everydayBanking.everydayBank.model.Transaction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TransactionControllerInterface {
    boolean depositMoney(@RequestParam int accountId, @RequestParam Double amountDeposited);
    boolean withdrawMoney(@RequestParam int accountId, @RequestParam Double amountWithdrawn);
    boolean transferMoney(@RequestParam int senderAccountId, @RequestParam int receiverAccountId, @RequestParam Double amountTransfered);
    List<Transaction> allTransactionsGivenAccountId(@PathVariable int accountId);
    void deleteTransactionGivenTransactionId(@PathVariable int transactionId);
}
