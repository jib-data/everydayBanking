package com.everydayBanking.everydayBank.repository;

import com.everydayBanking.everydayBank.model.Account;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}