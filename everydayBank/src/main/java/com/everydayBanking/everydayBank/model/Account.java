package com.everydayBanking.everydayBank.model;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "customer_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int accountId;
    private String accountNumber;
    private Double accountBalance;
    private String accountType;
    private LocalDateTime creation;
    public Customer getCustomer() {
        return customer;
    }
    @ManyToOne(optional = false)
    @JoinColumn(name="customer_id", nullable = false)
    Customer customer;



    public Account() {
    }

    public Account(String accountNumber, Double accountBalance, String accountType, LocalDateTime creation, int customerId) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.creation = creation;

    }

    public Account(int accountId, String accountNumber, Double accountBalance, String accountType, LocalDateTime creation, int customerId) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.creation = creation;

    }


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public LocalDateTime getCreation() {
        return creation;
    }

    public void setCreation(LocalDateTime creation) {
        this.creation = creation;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId == account.accountId && Objects.equals(accountNumber, account.accountNumber) && Objects.equals(accountBalance, account.accountBalance) && Objects.equals(accountType, account.accountType) && Objects.equals(creation, account.creation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountNumber, accountBalance, accountType, creation);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountBalance=" + accountBalance +
                ", accountType='" + accountType + '\'' +
                ", creation=" + creation +
                '}';
    }
}
