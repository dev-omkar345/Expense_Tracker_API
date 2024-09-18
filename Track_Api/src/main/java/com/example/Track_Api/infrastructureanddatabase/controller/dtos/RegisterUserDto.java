package com.example.Track_Api.infrastructureanddatabase.controller.dtos;

import lombok.Data;

@Data
public class RegisterUserDto {
	
	private Integer user_id;
	
	private String first_name;
	
	private String last_name;
	
    private String email;
    
    private String password;
    
    
}