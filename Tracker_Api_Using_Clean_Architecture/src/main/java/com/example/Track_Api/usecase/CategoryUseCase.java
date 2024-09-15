package com.example.Track_Api.usecase;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.Track_Api.entity.Category;
import com.example.Track_Api.entity.User;
import com.example.Track_Api.infrastructureanddatabase.gateway.CategoryDatabaseGateway;
import com.example.Track_Api.infrastructureanddatabase.gateway.UserDatabaseGateway;


//@Service
public class CategoryUseCase implements CategorySerInt {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryUseCase.class);
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	private CategoryDatabaseGateway categoryGateway;
	
	private UserDatabaseGateway userDatabaseGateway;
	
	public CategoryUseCase(CategoryDatabaseGateway categoryGateway, UserDatabaseGateway userDatabaseGateway) {
		this.categoryGateway = categoryGateway;
		this.userDatabaseGateway = userDatabaseGateway;
	}
	
	public Category saveTheCategory(String title, String description, Double catExpense, String email)
	{			
			User  userObj =  (User) userDetailsService.loadUserByUsername(email); 
				
			Category category = new Category();
			
			Double total = userObj.getTotalexpense();
						
			if(total == null) {
				userObj.setTotalexpense(catExpense);
			}else{
				total += catExpense;	
				userObj.setTotalexpense(total);
			}
							
			category.setUser(userObj);
		
			category.setTitle(title);
		
			category.setDescription(description);
			
			category.setCateExpense(catExpense);
			
			categoryGateway.create(category);
			
			userDatabaseGateway.create(userObj);
			
			logger.info("categories saved");
							
			return category;  // returning category object for transaction ......
			
			
	}
	
	public List<Category> getCatByUserService(String email)
	{
		User user1 =  (User) userDetailsService.loadUserByUsername(email); 
		
		Integer userId = user1.getUser_id();
		
		List<Category> catList = categoryGateway.searchCategoriesByUserId(userId);
		
		return catList;
	}
	
	
	public Category getCatByUserServiceById(String email,int catId)
	{
		User user1 =  (User) userDetailsService.loadUserByUsername(email); 
		
		Integer userId = user1.getUser_id();
		
	    Category category = categoryGateway.searchSpecificCategoryByUserId(userId, catId);
	    
	    return category;
	}

}
