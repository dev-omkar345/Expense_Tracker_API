package com.example.Track_Api.usecase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Track_Api.entity.User;
import com.example.Track_Api.infrastructureanddatabase.gateway.UserDatabaseGateway;
import com.example.Track_Api.usecase.dtos.LoginUserDto;
import com.example.Track_Api.usecase.dtos.RegisterUserDto;

public class AuthenticationUseCase implements IAuthentication
{
    private final UserDatabaseGateway userDatabaseGateway;//constructor injection....
    
    private  final PasswordEncoder passwordEncoder;
    
    private  final AuthenticationManager authenticationManager;
    
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationUseCase.class);

    public AuthenticationUseCase(UserDatabaseGateway userDatabaseGateway, AuthenticationManager authenticationManager,PasswordEncoder passwordEncoder) 
    {
        this.authenticationManager = authenticationManager;
        this.userDatabaseGateway = userDatabaseGateway;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto input) 
    {
    	User user = new User();
    	user.setUser_id(input.getUser_id());
    	user.setFirst_name(input.getFirst_name());
    	user.setLast_name(input.getLast_name());
    	user.setEmail(input.getEmail());
    	user.setPassword(passwordEncoder.encode(input.getPassword()));

        return userDatabaseGateway.create(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        logger.info("checking the method....");
        return userDatabaseGateway.findsssByEmail(input.getEmail());
    }
}