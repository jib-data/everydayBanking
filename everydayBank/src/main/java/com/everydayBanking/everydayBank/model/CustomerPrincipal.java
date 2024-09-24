package com.everydayBanking.everydayBank.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomerPrincipal implements UserDetails {

    private Customer customer;

    public CustomerPrincipal(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return customer.getPassword();
    }

    @Override
    public String getUsername() {
        return customer.getUsername();
    }

    public String getFirstName(){ return customer.getFirstName();}

    public String getLastName(){
        return customer.getLastName();
    }
    public List<Account> getCustomerAccounts(){
        return customer.getAccounts();
    }
    @JsonIgnore
    public int getCustomerId(){
        return customer.getCustomer_id();
    }
}
