package com.example.Track_Api.entity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.Role;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.GrantedAuthority;


public interface UserIn //business rules
{
	User create(User user);
	
//	Optional<User> searchByEmail(String email);
	
	User findsssByEmail(String email);
	
	Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles);

}
