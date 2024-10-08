package com.everydayBanking.everydayBank.service;

import com.everydayBanking.everydayBank.model.Customer;
import com.everydayBanking.everydayBank.model.DashboardObject;
import com.everydayBanking.everydayBank.model.LoginObject;


public interface CustomerServiceInterface {
    DashboardObject signUp( Customer newCustomer);
    DashboardObject login(LoginObject loginObjet);
}
