package com.example.Track_Api.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;


public interface UserIn //business rules
{
	User create(User user);
	
//	Optional<User> searchByEmail(String email);
	
	User findsssByEmail(String email);

}
