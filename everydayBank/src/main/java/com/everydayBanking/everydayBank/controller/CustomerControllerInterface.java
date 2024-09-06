package com.everydayBanking.everydayBank.controller;

import com.everydayBanking.everydayBank.model.Customer;
import com.everydayBanking.everydayBank.model.DashboardObject;

public interface CustomerControllerInterface {
    DashboardObject signUpCustomer(Customer newCustomer);

}
