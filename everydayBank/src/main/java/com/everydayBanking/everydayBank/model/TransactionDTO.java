package com.everydayBanking.everydayBank.model;

import java.time.LocalDateTime;

public class TransactionDTO {
    private int transactionId;
    private TransactionType transactionType;
    private Double amount;
    private LocalDateTime transactionDate;

    public TransactionDTO(Transaction transaction){
        this.transactionId = transaction.getTransactionId();
        this.transactionType = transaction.getTransactionType();
        this.amount = transaction.getAmount();
        this.transactionDate = transaction.getTransactionDate();
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
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
        return "TransactionDTO{" +
                "transactionId=" + transactionId +
                ", transactionType=" + transactionType +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
