package com.everydayBanking.everydayBank.model;


import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Transaction {
    int transactioId;
    String transactionType;
    String amount;
    LocalDateTime transactionDate;
    int accountId;

    public Transaction() {
    }

    public Transaction(String transactionType, String amount, LocalDateTime transactionDate, int accountId) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.accountId = accountId;
    }

    public Transaction(int transactioId, String transactionType, String amount, LocalDateTime transactionDate, int accountId) {
        this.transactioId = transactioId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.accountId = accountId;
    }

    public int getTransactioId() {
        return transactioId;
    }

    public void setTransactioId(int transactioId) {
        this.transactioId = transactioId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactioId=" + transactioId +
                ", transactionType='" + transactionType + '\'' +
                ", amount='" + amount + '\'' +
                ", transactionDate=" + transactionDate +
                ", accountId=" + accountId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return transactioId == that.transactioId && accountId == that.accountId && Objects.equals(transactionType, that.transactionType) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactioId, transactionType, amount, transactionDate, accountId);
    }

}
