package com.everydayBanking.everydayBank.controller;

import com.everydayBanking.everydayBank.model.Customer;
import com.everydayBanking.everydayBank.model.DashboardObject;
import com.everydayBanking.everydayBank.model.LoginObject;
import com.everydayBanking.everydayBank.service.AccountService;
import com.everydayBanking.everydayBank.service.CustomerService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController implements CustomerControllerInterface{
    CustomerService customerService;
    AccountService accountService;

    @Override
    public DashboardObject signUpCustomer(Customer newCustomer) {
        return null;
    }

    @Override
    public DashboardObject loginCustomer(LoginObject loginObject) {
        return null;
    }
}
