package com.example.Track_Api.usecase;

import com.example.Track_Api.entity.User;
import com.example.Track_Api.usecase.dtos.LoginUserDto;
import com.example.Track_Api.usecase.dtos.RegisterUserDto;

public interface IAuthentication {
	
	 public User signup(RegisterUserDto input);
	 
	 public User authenticate(LoginUserDto input);

}
