package com.everydayBanking.everydayBank.service;

import com.everydayBanking.everydayBank.model.Customer;
import com.everydayBanking.everydayBank.model.DashboardObject;
import com.everydayBanking.everydayBank.model.LoginObject;
import org.springframework.web.bind.annotation.RequestBody;

public interface CustomerServiceInterface {
    Customer signUp(@RequestBody Customer newCustomer);
    DashboardObject login(@RequestBody LoginObject loginObjet);
}
