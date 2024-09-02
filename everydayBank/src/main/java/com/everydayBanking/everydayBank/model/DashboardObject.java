package com.everydayBanking.everydayBank.model;

import java.util.List;

public class DashboardObject {
    private String firstName;
    private String lastName;
    private List<Account> customerAccounts;

    public DashboardObject() {
    }

    public DashboardObject(String firstName, String lastName, List<Account> customerAccounts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerAccounts = customerAccounts;
    }

}
