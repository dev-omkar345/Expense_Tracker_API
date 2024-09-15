package com.example.Track_Api.infrastructureanddatabase.gateway;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Track_Api.entity.User;
import com.example.Track_Api.entity.UserIn;
import com.example.Track_Api.infrastructureanddatabase.UserRepository;

public class UserDatabaseGateway implements UserIn 
{	
	
    private final UserRepository usersRepo;
    
	public UserDatabaseGateway(UserRepository userRepo) 
	{
	        this.usersRepo = userRepo;
	}

	@Override
	public User create(User user) {
		return usersRepo.save(user);
	}


	@Override
	public User findsssByEmail(String email) {
		return usersRepo.findsByEmail(email);
	}

}
