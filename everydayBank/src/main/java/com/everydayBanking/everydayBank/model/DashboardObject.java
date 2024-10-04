package com.everydayBanking.everydayBank.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DashboardObject {
    private String firstName;
    private String lastName;
    private String jwtToken;
    private List<AccountDTO> customerAccounts;

    public DashboardObject() {
    }

    public DashboardObject(Customer customer, String jwtToken) {
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.jwtToken = jwtToken;
        this.customerAccounts = customer.getAccounts()
                .stream()
                    .map(account -> new AccountDTO(account)).collect(Collectors.toList());
    }
    public DashboardObject(CustomerPrincipal customer, String jwtToken) {
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.jwtToken = jwtToken;
        this.customerAccounts = customer.getCustomerAccounts()
                .stream()
                .map(account -> new AccountDTO(account)).collect(Collectors.toList());
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

    public List<AccountDTO> getCustomerAccounts() {
        return customerAccounts;
    }

    public void setCustomerAccounts(List<AccountDTO> customerAccounts) {
        this.customerAccounts = customerAccounts;
    }

    @Override
    public String toString() {
        return "DashboardObject{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jwtToken='" + jwtToken + '\'' +
                ", customerAccounts=" + customerAccounts +
                '}';
    }
}
