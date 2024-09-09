package com.everydayBanking.everydayBank.service;

import com.everydayBanking.everydayBank.model.Customer;
import com.everydayBanking.everydayBank.model.DashboardObject;
import com.everydayBanking.everydayBank.model.LoginObject;
import com.everydayBanking.everydayBank.repository.CustomerRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;

public class CustomerService implements CustomerServiceInterface{
    CustomerRepository customerRepository;
    AuthenticationManager authManager;


    public CustomerService(CustomerRepository customerRepository, AuthenticationManager authManager){
        this.customerRepository = customerRepository;
        this.authManager = authManager;
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
                return null;
            }
        } else {
            return null;
        }

    }

    @Override
    public DashboardObject login(@RequestBody LoginObject loginObjet) {
        //        Create an authentication token
        Authentication unauthenticatedRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(loginObjet.getUsername(), loginObjet.getPassword());
        Authentication authenticationResponse =
                authManager.authenticate(unauthenticatedRequest);



        return null;
    }
}
