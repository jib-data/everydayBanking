package com.everydayBanking.everydayBank.repository;


import com.everydayBanking.everydayBank.model.DeletedAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeletedAccountRepository extends JpaRepository<DeletedAccount, Integer> {
}
