package com.example.Track_Api.infrastructureanddatabase.gateway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Track_Api.entity.Category;
import com.example.Track_Api.entity.CategoryIn;
import com.example.Track_Api.infrastructureanddatabase.CategoryRepo;

public class CategoryDatabaseGateway implements CategoryIn {
	
	private final  CategoryRepo catRepo;
	
	public CategoryDatabaseGateway(CategoryRepo catRepo) {
		this.catRepo = catRepo;
	}
	
	@Override
	public List<Category> searchCategoriesByUserId(int userId) {
		return catRepo.findCategoriesByUserId(userId);
	}

	@Override
	public Category searchSpecificCategoryByUserId(int userId, int catId) {		
		return catRepo.findSpecificCategoryByUserId(userId, catId);
	}

	@Override
	public void create(Category category) {
		catRepo.save(category);
	}

}
