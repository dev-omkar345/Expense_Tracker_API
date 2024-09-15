package com.example.Track_Api.usecase;

import com.example.Track_Api.entity.Category;
import com.example.Track_Api.entity.User;

public interface TransactionService {
	
	void saveCategoryInTrans(Category category);
	
	void saveUser(User authenticatedUser);

}
