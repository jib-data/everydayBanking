package com.everydayBanking.everydayBank.repository;

import com.everydayBanking.everydayBank.model.Account;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
//    @Query("SELECT a FROM Account a ORDER BY a.accountId DESC")
    Optional<Account> findTopByOrderByAccountIdDesc();
    @Query("SELECT a FROM Account a WHERE a.customer.customerId = :customerId")
    List<Account> findByCustomerId(@Param("customerId") int customerId);
}
