package com.everydayBanking.everydayBank.controller;

import com.everydayBanking.everydayBank.model.Customer;
import com.everydayBanking.everydayBank.model.DashboardObject;
import com.everydayBanking.everydayBank.model.LoginObject;
import com.everydayBanking.everydayBank.service.AccountService;
import com.everydayBanking.everydayBank.service.CustomerService;
import com.everydayBanking.everydayBank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController implements CustomerControllerInterface{
    CustomerService customerService;
    AccountService accountService;
    TransactionService transactionService;

    @Autowired
    public CustomerController(CustomerService customerService, AccountService accountService, TransactionService transactionService){
        this.customerService = customerService;
        this.accountService = accountService;
        this.transactionService = transactionService;
    }
    @PostMapping("/signup")
    @Override
    public DashboardObject  signUpCustomer(@RequestBody Customer newCustomer) {
//        System.out.println(newCustomer);
        DashboardObject dashboardObject = customerService.signUp(newCustomer);
         if (dashboardObject != null){
             return dashboardObject;
         } else {
            return null;
         }

    }
    @PostMapping("/login")
    @Override
    public DashboardObject loginCustomer(LoginObject loginObject) {
        DashboardObject dashboardObject = customerService.login(loginObject);
        if (dashboardObject != null){
            return dashboardObject;
        }
        return null;
    }
}
