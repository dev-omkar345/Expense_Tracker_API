package com.example.Track_Api.entity;

import java.util.List;

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
import lombok.Setter;

@Entity
@Table(name = "et_categories")
@Setter
@Getter
public class Category implements CategoryIn
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Integer category_id;
	
	@JoinColumn(name = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@Transient
	@JoinColumn(name = "transaction_id")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Transaction trans;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "category_expense")
	private Double cateExpense;

	@Override
	public List<Category> searchCategoriesByUserId(int userId) 
	{
		return null;
	}

	@Override
	public Category searchSpecificCategoryByUserId(int userId, int catId) {
		return null;
	}

	@Override
	public void create(Category category) {
		
	}
	


}