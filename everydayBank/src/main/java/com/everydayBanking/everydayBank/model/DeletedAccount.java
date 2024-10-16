package com.everydayBanking.everydayBank.model;


import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class DeletedAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;
    @Column(name = "username")
    private String username;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "account_balance")
    private Double accountBalance;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @Column(name = "deletion_date")
    private LocalDateTime deletionDate;

    public DeletedAccount() {
    }

    @Autowired
    public DeletedAccount(int accountId, String username, String firstname, String lastName, String accountNumber, Double accountBalance, String accountType, LocalDateTime creationDate, LocalDateTime deletionDate) {
        this.accountId = accountId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastName;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.creationDate = creationDate;
        this.deletionDate = deletionDate;
    }
//    @Autowired
//    public DeletedAccount(int accountId, String username, String firstname, String lastname, String accountType, String accountNumber, LocalDateTime creationDate, LocalDateTime deletionDate) {
//        this.accountId = accountId;
//        this.username = username;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.accountType = accountType;
//        this.accountNumber = accountNumber;
//        this.creationDate = creationDate;
//        this.deletionDate = deletionDate;
//    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getDeletionDate() {
        return deletionDate;
    }

    public void setDeletionDate(LocalDateTime deletionDate) {
        this.deletionDate = deletionDate;
    }
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeletedAccount that = (DeletedAccount) o;
        return accountId == that.accountId && Objects.equals(username, that.username) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(accountBalance, that.accountBalance) && Objects.equals(accountType, that.accountType) && Objects.equals(creationDate, that.creationDate) && Objects.equals(deletionDate, that.deletionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, username, firstname, lastname, accountNumber, accountBalance, accountType, creationDate, deletionDate);
    }

    @Override
    public String toString() {
        return "DeletedAccount{" +
                "accountId=" + accountId +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountBalance=" + accountBalance +
                ", accountType='" + accountType + '\'' +
                ", creationDate=" + creationDate +
                ", deletionDate=" + deletionDate +
                '}';
    }
}
