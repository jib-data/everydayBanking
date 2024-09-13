package com.everydayBanking.everydayBank.model;

import java.util.List;

public class DashboardObject {
    private String firstName;
    private String lastName;
    private String jwtToken;
    private Account account;
    private List<Account> customerAccounts;

    public DashboardObject() {
    }

    public DashboardObject(String firstName, String lastName, String jwtToken, Account account, List<Account> customerAccounts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jwtToken = jwtToken;
        this.account = account;
        this.customerAccounts = customerAccounts;
    }

    public DashboardObject(String firstName, String lastName, List<Account> customerAccounts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerAccounts = customerAccounts;
    }
    public DashboardObject(String firstName, String lastName, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
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

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public List<Account> getCustomerAccounts() {
        return customerAccounts;
    }

    public void setCustomerAccounts(List<Account> customerAccounts) {
        this.customerAccounts = customerAccounts;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
