package com.everydayBanking.everydayBank.model;

import java.time.LocalDateTime;

public class RegisterationObject {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String accountType;
    private  String address;
    private LocalDateTime creationDate;

    public RegisterationObject() {
    }

    public RegisterationObject(String firstName, String lastName, String username, String password, String email, String accountType, String phone, String address, LocalDateTime creationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.accountType = accountType;
        this.phone = phone;
        this.address = address;
        this.creationDate = creationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
