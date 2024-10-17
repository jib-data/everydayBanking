package com.everydayBanking.everydayBank.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int transactionId;
    @Column(name = "transaction_type")
    private TransactionType transactionType;
    @Column(name = "transaction_amount")
    private Double amount;
    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;
    @ManyToOne(optional = false)
    @JoinColumn (name = "account_id", nullable = false)
    private Account account;


    public Transaction() {
    }

    public Transaction(TransactionType transactionType, Double amount, LocalDateTime transactionDate, Account account) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.account = account;

    }

    public Transaction(int transactioId, TransactionType transactionType, Double amount, LocalDateTime transactionDate) {
        this.transactionId = transactioId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public int getTransactioId() {
        return transactionId;
    }

    public void setTransactioId(int transactioId) {
        this.transactionId = transactioId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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
