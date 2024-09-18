package com.example.Track_Api.usecase;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Track_Api.entity.Category;
import com.example.Track_Api.entity.Transaction;
import com.example.Track_Api.entity.User;
import com.example.Track_Api.infrastructureanddatabase.TransactionRepo;
import com.example.Track_Api.infrastructureanddatabase.UserRepository;
import com.example.Track_Api.infrastructureanddatabase.gateway.TransactionDatabaseGateway;

public class TransactionUseCase implements ITransaction
{
	private final TransactionDatabaseGateway transactionDatabaseGateway;
	
	@Autowired
	private UserRepository userRepo;
	
	public TransactionUseCase(TransactionDatabaseGateway transactionDatabaseGateway) {
		this.transactionDatabaseGateway = transactionDatabaseGateway;
	}
		
	private static final Logger logger = LoggerFactory.getLogger(TransactionUseCase.class);
	
	@Override
	public Transaction getTheTransactions(String email) {
		
		Optional<User> userObj = Optional.ofNullable(userRepo.findsByEmail(email));
		
		int userId = userObj.get().getUser_id();
		
		logger.info("Got transactions....");
		
		return transactionDatabaseGateway.getTransactions(userId);		
		
	}
	
}
