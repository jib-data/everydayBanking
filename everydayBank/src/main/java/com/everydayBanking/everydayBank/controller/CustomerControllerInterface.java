package com.everydayBanking.everydayBank.controller;

import com.everydayBanking.everydayBank.model.Customer;
import com.everydayBanking.everydayBank.model.DashboardObject;
import com.everydayBanking.everydayBank.model.LoginObject;

public interface CustomerControllerInterface {
    DashboardObject signUpCustomer(Customer newCustomer);
    DashboardObject loginCustomer(LoginObject loginObject);
}
