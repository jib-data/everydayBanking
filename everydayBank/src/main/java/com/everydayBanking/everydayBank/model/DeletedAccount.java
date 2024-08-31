package com.everydayBanking.everydayBank.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class DeletedAccount {

    @Id
    int accountId;
    String username;
    String firstname;
    String lastname;
    String accountNumber;
    String accountType;
    LocalDateTime creationDate;
    LocalDateTime deletionDate;

    public DeletedAccount() {
    }

    public DeletedAccount(String username, String firstname, String lastName, String accountNumber, String accountType, LocalDateTime creationDate, LocalDateTime deletionDate) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.creationDate = creationDate;
        this.deletionDate = deletionDate;
    }

    public DeletedAccount(int accountId, String username, String firstname, String lastname, String accountType, String accountNumber, LocalDateTime creationDate, LocalDateTime deletionDate) {
        this.accountId = accountId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.creationDate = creationDate;
        this.deletionDate = deletionDate;
    }

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

    @Override
    public String toString() {
        return "DeletedAccount{" +
                "accountId=" + accountId +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", creationDate=" + creationDate +
                ", deletionDate=" + deletionDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeletedAccount that = (DeletedAccount) o;
        return accountId == that.accountId && Objects.equals(username, that.username) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(accountType, that.accountType) && Objects.equals(creationDate, that.creationDate) && Objects.equals(deletionDate, that.deletionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, username, firstname, lastname, accountNumber, accountType, creationDate, deletionDate);
    }
}
