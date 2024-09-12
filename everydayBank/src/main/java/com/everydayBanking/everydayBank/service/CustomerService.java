package com.everydayBanking.everydayBank.service;

import com.everydayBanking.everydayBank.model.Customer;
import com.everydayBanking.everydayBank.model.CustomerPrincipal;
import com.everydayBanking.everydayBank.model.DashboardObject;
import com.everydayBanking.everydayBank.model.LoginObject;
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
    public Customer signUp(@RequestBody Customer newCustomer) {
        Customer existingCustomer = customerRepository.findByUsername(newCustomer.getUsername());
        if (existingCustomer == null){
            if(newCustomer.getPassword().equals(newCustomer.getPasswordCopy())){
//                User does not already exist so we...
//                Create a new customer
                Customer createdCustomer = new Customer();
//                instantiate a password encryption object
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                createdCustomer.setUsername(newCustomer.getUsername());
//                Encrypt password
                createdCustomer.setPassword(passwordEncoder.encode(newCustomer.getPassword()));
                createdCustomer.setFirstName(newCustomer.getFirstName());
                createdCustomer.setLastname(newCustomer.getLastname());
                createdCustomer.setEmail(newCustomer.getEmail());
                createdCustomer.setPhone(newCustomer.getPhone());
                createdCustomer.setCreation_date(newCustomer.getCreation_date());

                return customerRepository.save(createdCustomer);

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

            String token = jwtUtils.generateJwtToken(customerDetails);
            DashboardObject dashboardObject = new DashboardObject();
            dashboardObject.setJwtToken(token);
            dashboardObject.setFirstName(customerDetails.getFirstName());
            dashboardObject.setLastName(customerDetails.getLastName());
            dashboardObject.setCustomerAccounts(accountService.getCustomerAccountsById(customerDetails.getCustomerId()));
        } catch (AuthenticationException e){
            e.getMessage();
        }

//      Set security context
//       Grab user detail
//       Generate token
//       create an instance of the response object
//        Return it.


        return null;
    }
}
