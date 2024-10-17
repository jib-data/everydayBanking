package com.everydayBanking.everydayBank.repository;


import com.everydayBanking.everydayBank.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query("Select t from Transaction t Where t.account.accountId= :accountId")
    List<Transaction> findTransactionsByAccountId(@Param("accountId") int accountId);
}
