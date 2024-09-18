package com.example.Track_Api.usecase;

import com.example.Track_Api.entity.Category;
import com.example.Track_Api.entity.Transaction;
import com.example.Track_Api.entity.User;

public interface ITransaction {
	
	Transaction getTheTransactions(String email);

}
