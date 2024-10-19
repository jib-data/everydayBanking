package com.everydayBanking.everydayBank.controller;

import com.everydayBanking.everydayBank.model.Transaction;
import com.everydayBanking.everydayBank.service.TransactionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController implements TransactionControllerInterface{
    TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public boolean depositMoney(@RequestParam int accountId, @RequestParam Double amountDeposited) {

        return transactionService.depositMoney(accountId, amountDeposited);
    }

    @Override
    public boolean withdrawMoney(@RequestParam int accountId, @RequestParam Double amountWithdrawn) {

        return transactionService.withdrawMoney(accountId, amountWithdrawn);
    }

    @Override
    public boolean transferMoney(@RequestParam int senderAccountId, @RequestParam int receiverAccountId,@RequestParam Double amountTransfered) {
        return transactionService.transferMoney(senderAccountId, receiverAccountId, amountTransfered);
    }

    @Override
    public List<Transaction> allTransactionsGivenAccountId(@PathVariable int accountId) {

        return transactionService.getAllTransactionsByAccountId(accountId);
    }

    @Override
    public void deleteTransactionGivenTransactionId(@PathVariable int transactionId) {
        transactionService.deleteTransactionByTransactionId(transactionId);
    }


}
