package com.example.Track_Api.infrastructureanddatabase;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Track_Api.entity.User;


//@Repository
public interface UserRepository extends JpaRepository<User, Integer> 
{
    Optional<User> searchByEmail(String email);
    
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findsByEmail(@Param("email") String email);
}
