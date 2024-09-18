package com.example.Track_Api.infrastructureanddatabase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Track_Api.entity.Transaction;


//@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
	
	@Query("Select t from Transaction t where t.user.id = :userId")
	Transaction getByTransId(@Param("userId") int userId);

}
