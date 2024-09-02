package com.everydayBanking.everydayBank.controller;

import com.everydayBanking.everydayBank.model.Transaction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TransactionControllerInterface {
    Transaction depositMoney(@RequestParam int accountId, @RequestParam int amountDeposited);
    Transaction withdrawMoney(@RequestParam int accountId, @RequestParam int amountWithdrawn);
    Transaction transferMoney(@RequestParam int senderAccountId, @RequestParam int receiverAccountId, @RequestParam int amountTransfered);
    List<Transaction> allTransactionsGivenAccountId(@PathVariable int accountId);
    Transaction deleteTransactionGivenTransactionId(@PathVariable int transactionId);
    Transaction getTransactionByTransactionId(@PathVariable int transactionId);
}
