package com.example.Track_Api.infrastructureanddatabase.controller;

import java.awt.RenderingHints.Key;
import java.io.ObjectInputFilter.Status;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Track_Api.entity.Category;
import com.example.Track_Api.entity.User;
import com.example.Track_Api.infrastructureanddatabase.controller.dtos.CateRegDto;
import com.example.Track_Api.infrastructureanddatabase.controller.dtos.LoginResponse;
import com.example.Track_Api.usecase.AuthenticationUseCase;
import com.example.Track_Api.usecase.CategorySerInt;
import com.example.Track_Api.usecase.TransactionService;
import com.example.Track_Api.usecase.dtos.LoginUserDto;
import com.example.Track_Api.usecase.dtos.RegisterUserDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;


//@RequestMapping("/api/users")
//@RestController
//public class AuthenticationController 
//{	
//    private final JwtService jwtService;
//    
//    private final AuthenticationUseCase authenticationService;
//    
//    private  final CategorySerInt categoryService;
//    
//    @Autowired
//    private TransactionService TransServ;// Not recommended on actual Production code
//
//    public AuthenticationController(JwtService jwtService, AuthenticationUseCase authenticationService, CategorySerInt categoryService ) 
//    {
//        this.jwtService = jwtService;
//        this.authenticationService = authenticationService;
//        this.categoryService = categoryService;
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) 
//    {
//        User registeredUser = authenticationService.signup(registerUserDto);
//
//        return ResponseEntity.ok(registeredUser);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) 
//    {
//        User authenticatedUser = authenticationService.authenticate(loginUserDto);
//
//        String jwtToken = jwtService.generateToken(authenticatedUser);
//        
//        TransServ.saveUser(authenticatedUser);
//                
//        LoginResponse loginResponse = new LoginResponse();
//        
//        loginResponse.setExpiresIn(jwtService.getExpirationTime());
//        
//        loginResponse.setToken(jwtToken);
//        
//        return ResponseEntity.ok(loginResponse);
//    }
//    
//    @PostMapping("/categories")
//    public void saveUserCategories(@RequestHeader("Authorization") String authHeader,
//    	                                           @RequestBody CateRegDto cateRegDto)
//    {    	
//    	String token = authHeader.replace("Bearer ", "");
//    	 	
//        String email = jwtService.extractUsername(token);
//        
//        if((!cateRegDto.getTitle().isEmpty()) && (!cateRegDto.getDescription().isEmpty()) && (cateRegDto.getCateExpense() != null))
//        {
//           Category category =  categoryService.saveCategory1(cateRegDto.getTitle(), cateRegDto.getDescription(), cateRegDto.getCateExpense(), email);
//            
//           TransServ.saveCategoryInTrans(category);
//        }
////        else
////        {
////        	throw new ApiReqException("partial content or empty content.");
////        }
//        
//    }
//    
//    
//    @GetMapping("/categories")
//    public ResponseEntity<List<Category>> getAllCategories(@RequestHeader("Authorization") String authHeader) 
//    {
//    	String token = authHeader.replace("Bearer ", "");
//	 	
//        String email = jwtService.extractUsername(token);
//        
//        List<Category> list = categoryService.getCatByUserService(email);
//        
//        return ResponseEntity.ok(list); 
//    }
//    
////    @GetMapping("/transaction/{name}")
////    public ResponseEntity<Transaction> getTransactionByUser(@RequestHeader("Authorization") String authHeader,
////    																			   @PathVariable  String user) 
////    {
////    	String token = authHeader.replace("Bearer ", "");
////	 	
////        String email = jwtService.extractUsername(token);
////        
////        List<Category> list = categoryService.getCatByUserService(email);
////        
////        Transaction t = new Transaction();
////        
////        return (ResponseEntity<Transaction>) ResponseEntity.ok(t); 
////    }
//    
//    @GetMapping("/categories/{id}")
//    public ResponseEntity<?> getCategoriesById(@RequestHeader("Authorization") String authHeader,
//    		                                                                  @PathVariable Integer id) 
//    {
//    	String token = authHeader.replace("Bearer ", "");
//	 	
//        String email = jwtService.extractUsername(token);
//        
//         Optional<Category> category = Optional.ofNullable(categoryService.getCatByUserServiceById(email,id));
//        
//         if(category.isPresent()) {
//        	 return new ResponseEntity<>(category.get(), HttpStatus.OK);
//         }
//         return new ResponseEntity<>("INVALID CATEGORY ID", HttpStatus.NOT_FOUND);
//    }
//    
//}