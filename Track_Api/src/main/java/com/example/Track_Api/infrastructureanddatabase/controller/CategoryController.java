package com.example.Track_Api.infrastructureanddatabase.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Track_Api.entity.Category;
import com.example.Track_Api.entity.User;
import com.example.Track_Api.exceptions.ApiReqException;
import com.example.Track_Api.infrastructureanddatabase.controller.dtos.CateRegDto;
import com.example.Track_Api.infrastructureanddatabase.controller.dtos.LoginResponse;
import com.example.Track_Api.usecase.AuthenticationUseCase;
import com.example.Track_Api.usecase.CategoryUseCase;
import com.example.Track_Api.usecase.dtos.LoginUserDto;
import com.example.Track_Api.usecase.dtos.RegisterUserDto;

@RestController
@RequestMapping("/api/users")
public class CategoryController {
	
	  private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	  private final CategoryUseCase categoryUseCase;
	  
	  private final JwtService jwtService;

	  public CategoryController(CategoryUseCase categoryUseCase, JwtService jwtService) 
	  {
	     this.categoryUseCase = categoryUseCase;
	     this.jwtService = jwtService;
	  }
	    
      @PostMapping("/categories")
      public void saveUserCategories(@RequestHeader("Authorization") String authHeader,
    	                                             @RequestBody CateRegDto cateRegDto)
       {    	
    	   String token = authHeader.replace("Bearer ", "");
    	
    	   logger.info("extracted token");
    	 	
           String email = jwtService.extractUsername(token);
        
    	   logger.info("extracted email");
        
           if((!cateRegDto.getTitle().isEmpty()) && (!cateRegDto.getDescription().isEmpty()) && (cateRegDto.getCateExpense() != null))
           {
               Category category =  categoryUseCase.saveTheCategory(cateRegDto.getTitle(), cateRegDto.getDescription(), cateRegDto.getCateExpense(), email);
          
	           logger.info("categories saved controller");
           }
           else
           {
        	   throw new ApiReqException("partial content or empty content.");
           }        
    }
    
    
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories(@RequestHeader("Authorization") String authHeader) 
    {
    	String token = authHeader.replace("Bearer ", "");
	 	
        String email = jwtService.extractUsername(token);
        
        List<Category> list = categoryUseCase.getCatByUserService(email);
        
        return ResponseEntity.ok(list); 
    }
    
    @GetMapping("/categories/{id}")
    public ResponseEntity<?> getCategoriesById(@RequestHeader("Authorization") String authHeader,
    		                                                                   @PathVariable Integer id) 
    {
    	String token = authHeader.replace("Bearer ", "");
	 	
        String email = jwtService.extractUsername(token);
        
        Optional<Category> category = Optional.ofNullable(categoryUseCase.getCatByUserServiceById(email,id));
        
        if(category.isPresent()) {
         return new ResponseEntity<>(category.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("INVALID CATEGORY ID", HttpStatus.NOT_FOUND);
    }

}