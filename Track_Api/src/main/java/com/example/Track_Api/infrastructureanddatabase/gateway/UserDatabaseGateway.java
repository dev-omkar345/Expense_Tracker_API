package com.example.Track_Api.infrastructureanddatabase.gateway;

import java.util.Collection;
import java.util.Optional;

import org.apache.catalina.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import com.example.Track_Api.entity.User;
import com.example.Track_Api.entity.UserIn;
import com.example.Track_Api.infrastructureanddatabase.UserRepository;

public class UserDatabaseGateway implements UserIn 
{	
	
    private final UserRepository usersRepo;
    
	public UserDatabaseGateway(UserRepository userRepo) {
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
		// TODO Auto-generated method stub
		return null;
	}

}
