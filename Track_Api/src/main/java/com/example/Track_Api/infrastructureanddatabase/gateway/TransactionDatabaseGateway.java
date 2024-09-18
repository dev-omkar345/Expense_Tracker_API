package com.example.Track_Api.infrastructureanddatabase.gateway;

import com.example.Track_Api.entity.Transaction;
import com.example.Track_Api.entity.TransactionIn;
import com.example.Track_Api.infrastructureanddatabase.TransactionRepo;

public class TransactionDatabaseGateway implements TransactionIn{
	
	private final TransactionRepo transRepo;
	
	public TransactionDatabaseGateway(TransactionRepo transRepo) {
		this.transRepo = transRepo;
	}

	@Override
	public Transaction getTransactions(int userId) {
		return transRepo.getByTransId(userId);
	}
	
	

}
