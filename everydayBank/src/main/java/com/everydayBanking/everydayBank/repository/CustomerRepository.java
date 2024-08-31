package com.everydayBanking.everydayBank.repository;

import com.everydayBanking.everydayBank.model.Customer;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;


@Entity
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
