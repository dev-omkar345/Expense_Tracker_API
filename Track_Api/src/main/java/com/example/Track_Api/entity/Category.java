package com.example.Track_Api.entity;

import java.util.List;



import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "et_categories")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category implements CategoryIn
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Integer category_id;
	
	
	@JoinColumn(name = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@JoinColumn(name = "cat_ref_trans")
	@Transient
	@Nullable
	@ManyToOne(fetch = FetchType.LAZY)
	private Integer cat_ref_trans;
	
	@Transient
	@Nullable
	@JoinColumn(name = "transaction_id", nullable = true)
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Transaction trans;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "category_expense")
	private Double cateExpense;

	@Override
	public List<Category> searchCategoriesByUserId(int userId) {
		return null;
	}

	@Override
	public Category searchSpecificCategoryByUserId(int userId, int catId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category createAndReturn(Category category) {
		// TODO Auto-generated method stub
		return null;
	}
	


}