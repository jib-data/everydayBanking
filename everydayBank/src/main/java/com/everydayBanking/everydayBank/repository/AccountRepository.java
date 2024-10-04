package com.everydayBanking.everydayBank.repository;

import com.everydayBanking.everydayBank.model.Account;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
//    @Query("SELECT a FROM Account a ORDER BY a.accountId DESC")
    Optional<Account> findTopByOrderByAccountIdDesc();
}
