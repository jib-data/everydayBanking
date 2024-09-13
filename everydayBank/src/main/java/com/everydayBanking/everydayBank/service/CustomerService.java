package com.everydayBanking.everydayBank.service;

import com.everydayBanking.everydayBank.model.*;
import com.everydayBanking.everydayBank.repository.CustomerRepository;
import com.everydayBanking.everydayBank.securityconfig.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;

public class CustomerService implements CustomerServiceInterface{
    CustomerRepository customerRepository;
    AuthenticationManager authManager;
    AccountService accountService;
    CustomerUserDetailsService customerUserDetailsService;
    JwtUtils jwtUtils;

    public CustomerService(CustomerRepository customerRepository, AuthenticationManager authManager, AccountService accountService,CustomerUserDetailsService customerUserDetailsService, JwtUtils jwtUtils){
        this.customerRepository = customerRepository;
        this.authManager = authManager;
        this.accountService = accountService;
        this.jwtUtils = jwtUtils;
        this.customerUserDetailsService = customerUserDetailsService;
    }
    @Override
    public DashboardObject signUp( Customer newCustomer) {
        Customer existingCustomer = customerRepository.findByUsername(newCustomer.getUsername());
        if (existingCustomer == null){
            if(!newCustomer.getPassword().equals(newCustomer.getPasswordCopy())){

                Customer createdCustomer = createCustomer(newCustomer);
                Customer createdCustomerSaved = customerRepository.save(createdCustomer);
                Account createdAccount = accountService.createAccount(createdCustomerSaved);
                String token = jwtUtils.generateJwtToken(createdCustomerSaved.getUsername());
                DashboardObject dashboardObject = setDashBoardDetails(createdCustomerSaved, token, createdAccount);


                return null;

            } else {
//                throw exception for password doesn't match
                return null;
            }
        } else {
//            throw exception for user already exists
            return null;
        }

    }

    @Override
    public DashboardObject login(@RequestBody LoginObject loginObjet) {
        Authentication authentication;
        try {

             authentication =
                    authManager.authenticate(new UsernamePasswordAuthenticationToken(loginObjet.getUsername(), loginObjet.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            CustomerPrincipal customerDetails = (CustomerPrincipal) authentication.getPrincipal();

            String token = jwtUtils.generateJwtToken(customerDetails.getUsername());
            DashboardObject dashboardObject = new DashboardObject();
            dashboardObject.setJwtToken(token);
            dashboardObject.setFirstName(customerDetails.getFirstName());
            dashboardObject.setLastName(customerDetails.getLastName());
            dashboardObject.setCustomerAccounts(accountService.getCustomerAccountsById(customerDetails.getCustomerId()));

            return dashboardObject;
        } catch (AuthenticationException e){
            System.out.println(e.getMessage());
            return null;
        }


    }
//    Helper method
    public Customer createCustomer(Customer newCustomer){
        Customer createdCustomer = new Customer();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        createdCustomer.setUsername(newCustomer.getUsername());
        createdCustomer.setPassword(passwordEncoder.encode(newCustomer.getPassword()));
        createdCustomer.setFirstName(newCustomer.getFirstName());
        createdCustomer.setLastname(newCustomer.getLastname());
        createdCustomer.setEmail(newCustomer.getEmail());
        createdCustomer.setPhone(newCustomer.getPhone());
        createdCustomer.setCreation_date(newCustomer.getCreation_date());

        return createdCustomer;
    }

    public DashboardObject setDashBoardDetails(Customer createdCustomerSaved, String token, Account createdAccount){
        DashboardObject dashboardObject = new DashboardObject();

        dashboardObject.setFirstName(createdCustomerSaved.getFirstName());
        dashboardObject.setLastName(createdCustomerSaved.getLastName());
        dashboardObject.setJwtToken(token);
        dashboardObject.setAccount(createdAccount);
        return dashboardObject;
    }
}
