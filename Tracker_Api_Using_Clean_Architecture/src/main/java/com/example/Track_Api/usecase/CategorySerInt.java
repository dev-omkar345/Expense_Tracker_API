package com.example.Track_Api.usecase;

import java.util.List;

import com.example.Track_Api.entity.Category;


public interface CategorySerInt {
	
    Category saveTheCategory(String title, String description, Double cateExpense ,String email);
	
	List<Category> getCatByUserService(String email);
	
	Category getCatByUserServiceById(String email,int catId);
	
}
