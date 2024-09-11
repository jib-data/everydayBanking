package com.everydayBanking.everydayBank.model;

import java.util.List;

public class DashboardObject {
    private String firstName;
    private String lastName;
    private String jwtToken;
    private List<Account> customerAccounts;

    public DashboardObject() {
    }

    public DashboardObject(String firstName, String lastName, String jwtToken, List<Account> customerAccounts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jwtToken = jwtToken;
        this.customerAccounts = customerAccounts;

    }

}
