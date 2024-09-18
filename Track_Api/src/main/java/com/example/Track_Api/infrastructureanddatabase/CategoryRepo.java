package com.example.Track_Api.infrastructureanddatabase;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Track_Api.entity.Category;
//@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> 
{
	@Query("SELECT c FROM Category c WHERE c.user.id = :userId")
	List<Category> findCategoriesByUserId(@Param("userId") int userId);

	@Query("SELECT c FROM Category c WHERE c.user.id = :userId AND c.id = :catId")
	Category findSpecificCategoryByUserId(@Param("userId") int userId,@Param("catId") int catId);
}
