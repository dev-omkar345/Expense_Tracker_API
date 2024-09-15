package com.example.Track_Api.infrastructureanddatabase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Track_Api.entity.Transaction;


@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

}
