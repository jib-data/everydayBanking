package com.everydayBanking.everydayBank.controller;

import com.everydayBanking.everydayBank.model.Transaction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TranstractionController implements TransactionControllerInterface{
    @Override
    public Transaction depositMoney(@RequestParam int accountId, @RequestParam int amountDeposited) {
        return null;
    }

    @Override
    public Transaction withdrawMoney(@RequestParam int accountId, @RequestParam int amountWithdrawn) {
        return null;
    }

    @Override
    public Transaction transferMoney(@RequestParam int senderAccountId, @RequestParam int receiverAccountId,@RequestParam int amountTransfered) {
        return null;
    }

    @Override
    public List<Transaction> allTransactionsGivenAccountId(@PathVariable int accountId) {
        return List.of();
    }

    @Override
    public Transaction deleteTransactionGivenTransactionId(@PathVariable int transactionId) {
        return null;
    }

    @Override
    public Transaction getTransactionByTransactionId(int transactionId) {
        return null;
    }
}
