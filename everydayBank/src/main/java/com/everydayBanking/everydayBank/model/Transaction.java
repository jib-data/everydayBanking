package com.everydayBanking.everydayBank.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private int accountId;
    private TransactionType transactionType;
    private int amount;
    private LocalDateTime transactionDate;
    @ManyToOne(optional = false)
    @JoinColumn (name = "account_id", nullable = false)
    private Account account;


    public Transaction() {
    }

    public Transaction(int accountId, TransactionType transactionType, int amount, LocalDateTime transactionDate) {
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;

    }

//    public Transaction(int transactionId, TransactionType transactionType, String amount, LocalDateTime transactionDate) {
//        this.transactionId = transactionId;
//        this.transactionType = transactionType;
//        this.amount = amount;
//        this.transactionDate = transactionDate;
//    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactioId) {
        this.transactionId = transactioId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactioId=" + transactionId +
                ", transactionType='" + transactionType + '\'' +
                ", amount='" + amount + '\'' +
                ", transactionDate=" + transactionDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return transactionId == that.transactionId && Objects.equals(transactionType, that.transactionType) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, transactionType, amount, transactionDate);
    }

}
