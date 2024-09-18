package com.example.Track_Api.infrastructureanddatabase.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Track_Api.entity.User;
import com.example.Track_Api.infrastructureanddatabase.controller.dtos.LoginResponse;
import com.example.Track_Api.usecase.AuthenticationUseCase;
import com.example.Track_Api.usecase.IAuthentication;
import com.example.Track_Api.usecase.dtos.LoginUserDto;
import com.example.Track_Api.usecase.dtos.RegisterUserDto;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
   private static final Logger logger = LoggerFactory.getLogger(UserController.class);

   private final IAuthentication authenticationUseCase;
  
   private final JwtService jwtService;

   public UserController(AuthenticationUseCase authenticationUseCase, JwtService jwtService) 
   {
       this.authenticationUseCase = authenticationUseCase;
       this.jwtService = jwtService;
   }
	    
   @PostMapping("/register")
   public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) 
   {
       User registeredUser = authenticationUseCase.signup(registerUserDto);
        
       logger.info("categories saved controller");

       return ResponseEntity.ok(registeredUser);
   }

   @PostMapping("/login")
   public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) 
   {
	   User authenticatedUser = authenticationUseCase.authenticate(loginUserDto);

	   String jwtToken = jwtService.generateToken(authenticatedUser);
	        
       LoginResponse loginResponse = new LoginResponse();
	        
       loginResponse.setExpiresIn(jwtService.getExpirationTime());
	        
	   loginResponse.setToken(jwtToken);
	        
	   logger.info("User authenticated in User controller");
	        
	   return ResponseEntity.ok(loginResponse);
	}
	    

}
