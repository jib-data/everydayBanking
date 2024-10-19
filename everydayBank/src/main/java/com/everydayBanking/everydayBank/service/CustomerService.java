package com.everydayBanking.everydayBank.service;

import com.everydayBanking.everydayBank.model.*;
import com.everydayBanking.everydayBank.repository.CustomerRepository;
import com.everydayBanking.everydayBank.securityconfig.JwtUtils;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
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
    @Transactional
    public DashboardObject signUp( Customer newUser){
        Customer existingCustomer = customerRepository.findByUsername(newUser.getUsername());
        if (existingCustomer == null){
            Customer createdCustomer = createCustomer(newUser);
            Customer createdCustomerSaved = customerRepository.save(createdCustomer);
            Account createdAccount = accountService.createAccount(createdCustomerSaved.getCustomerId());
            createdCustomer.setAccounts(createdAccount);
            String token = jwtUtils.generateJwtToken(createdCustomerSaved.getUsername());
            DashboardObject dashboardObject = setDashBoardDetails(createdCustomerSaved, token);
            return dashboardObject;
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public DashboardObject login(LoginObject loginObjet) {
        Authentication authentication;
        try {
             authentication =
                    authManager.authenticate(new UsernamePasswordAuthenticationToken(loginObjet.getUsername(), loginObjet.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            CustomerPrincipal customerDetails = (CustomerPrincipal) authentication.getPrincipal();
            String token = jwtUtils.generateJwtToken(customerDetails.getUsername());
            DashboardObject dashboardObject = setDashBoardDetails(customerDetails, token);
            return dashboardObject;
        } catch (AuthenticationException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Customer createCustomer(Customer newUser){
        Customer createdCustomer = new Customer();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
//        System.out.println(newUser.getPassword());
        createdCustomer.setUsername(newUser.getUsername());
        createdCustomer.setPassword(passwordEncoder.encode(newUser.getPassword()));
        createdCustomer.setFirstName(newUser.getFirstName());
        createdCustomer.setLastname(newUser.getLastname());
        createdCustomer.setEmail(newUser.getEmail());
        createdCustomer.setPhone(newUser.getPhone());
        createdCustomer.setAddress(newUser.getAddress());
        createdCustomer.setCreation_date(newUser.getCreation_date());
        return createdCustomer;
    }



    public DashboardObject setDashBoardDetails(CustomerPrincipal customer, String token){
                    return new DashboardObject(customer, token);
//        dashboardObject.setFirstName(customer.getFirstName());
//        dashboardObject.setLastName(customer.getLastName());
//        dashboardObject.setJwtToken(token);
//        dashboardObject.setCustomerAccounts(customer.getCustomerAccounts());
//        return dashboardObject;
    }
    public DashboardObject setDashBoardDetails(Customer createdCustomerSaved, String token){
        return new DashboardObject(createdCustomerSaved, token);
//        dashboardObject.setFirstName(createdCustomerSaved.getFirstName());
//        dashboardObject.setLastName(createdCustomerSaved.getLastName());
//        dashboardObject.setJwtToken(token);
//        dashboardObject.setCustomerAccounts(createdCustomerSaved.getAccounts());
//        return dashboardObject;
    }
}
