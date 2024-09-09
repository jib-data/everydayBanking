package com.everydayBanking.everydayBank.service;


import com.everydayBanking.everydayBank.model.Customer;
import com.everydayBanking.everydayBank.model.CustomerPrincipal;
import com.everydayBanking.everydayBank.repository.CustomerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
    CustomerRepository customerRepository;

    public CustomerUserDetailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByUsername(username);
        if (customer != null){
            return new CustomerPrincipal(customer);
        } else{
            throw new UsernameNotFoundException("user not found");
        }

    }
}
