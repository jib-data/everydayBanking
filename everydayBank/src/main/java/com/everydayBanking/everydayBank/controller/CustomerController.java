package com.everydayBanking.everydayBank.controller;

import com.everydayBanking.everydayBank.model.Customer;
import com.everydayBanking.everydayBank.model.DashboardObject;
import com.everydayBanking.everydayBank.model.LoginObject;
import com.everydayBanking.everydayBank.service.AccountService;
import com.everydayBanking.everydayBank.service.CustomerService;
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

    @Autowired
    public CustomerController(CustomerService customerService, AccountService accountService){
        this.customerService = customerService;
        this.accountService = accountService;
    }
    @PostMapping("/signup")
    @Override
    public Customer  signUpCustomer(@RequestBody Customer newCustomer) {
//        System.out.println(newCustomer);
        Customer customer = customerService.signUp(newCustomer);
         if (customer != null){
             return customer;
         } else {
            return null;
         }

    }

    @Override
    public Customer loginCustomer(LoginObject loginObject) {
        return null;
    }
}
