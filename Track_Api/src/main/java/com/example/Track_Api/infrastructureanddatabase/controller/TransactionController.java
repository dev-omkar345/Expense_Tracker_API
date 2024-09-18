package com.example.Track_Api.infrastructureanddatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Track_Api.entity.Transaction;
import com.example.Track_Api.usecase.TransactionUseCase;

@RestController
@RequestMapping("/api/users")
public class TransactionController {
	
	private final TransactionUseCase transactionUseCase;
	
	private final JwtService jwtService;
	
	public TransactionController(TransactionUseCase transactionUseCase, JwtService jwtService) {
		this.transactionUseCase = transactionUseCase;
		this.jwtService = jwtService;
	}
	
    @GetMapping("/transaction")
    public ResponseEntity<Transaction> getTransactionByUserName(@RequestHeader("Authorization") String authHeader) 
    {
    	String token = authHeader.replace("Bearer ", "");
	 	
        String email = jwtService.extractUsername(token);
        
        Transaction transaction = transactionUseCase.getTheTransactions(email);
                
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

}
