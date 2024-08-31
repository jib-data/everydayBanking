package com.everydayBanking.everydayBank.repository;


import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
public interface DeletedAccount extends JpaRepository<DeletedAccount, Integer> {


}
