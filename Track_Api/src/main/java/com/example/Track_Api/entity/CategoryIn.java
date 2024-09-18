package com.example.Track_Api.entity;

import java.util.List;

import org.springframework.data.repository.query.Param;


public interface CategoryIn {
	
	List<Category> searchCategoriesByUserId(int userId);
	
	Category searchSpecificCategoryByUserId(int userId,int catId);
	
	void create(Category category);
	
	Category createAndReturn(Category category);

}
