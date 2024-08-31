package com.everydayBanking.everydayBank.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer_account")
public class Account {
    int accountId;
    String accountNumber;
    Double accountBalance;
    String accountType;
    LocalDateTime creation;
    int customerId;

    public Account() {
    }

    public Account(String accountNumber, Double accountBalance, String accountType, LocalDateTime creation, int customerId) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.creation = creation;
        this.customerId = customerId;
    }

    public Account(int accountId, String accountNumber, Double accountBalance, String accountType, LocalDateTime creation, int customerId) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.creation = creation;
        this.customerId = customerId;
    }


}
