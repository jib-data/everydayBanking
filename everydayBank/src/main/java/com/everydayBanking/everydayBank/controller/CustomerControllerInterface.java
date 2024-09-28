package com.everydayBanking.everydayBank.controller;

import com.everydayBanking.everydayBank.model.Customer;
import com.everydayBanking.everydayBank.model.DashboardObject;
import com.everydayBanking.everydayBank.model.LoginObject;
import org.springframework.http.ResponseEntity;

public interface CustomerControllerInterface {
    DashboardObject signUpCustomer(Customer newCustomer);
    DashboardObject loginCustomer(LoginObject loginObject);
}
