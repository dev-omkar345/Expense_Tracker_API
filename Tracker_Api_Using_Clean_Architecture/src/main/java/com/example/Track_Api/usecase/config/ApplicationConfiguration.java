package com.example.Track_Api.usecase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.Track_Api.infrastructureanddatabase.CategoryRepo;
import com.example.Track_Api.infrastructureanddatabase.UserRepository;
import com.example.Track_Api.infrastructureanddatabase.gateway.CategoryDatabaseGateway;
import com.example.Track_Api.infrastructureanddatabase.gateway.UserDatabaseGateway;
import com.example.Track_Api.usecase.AuthenticationUseCase;
import com.example.Track_Api.usecase.CategoryUseCase;


@Configuration
public class ApplicationConfiguration 
{	
    private final UserRepository userRepository;
    
    public ApplicationConfiguration(UserRepository userRepository) 
    {
        this.userRepository = userRepository;
    }

    @Bean
    UserDetailsService userDetailsService() 
    {
        return username -> userRepository.searchByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception 
    {
        return config.getAuthenticationManager();
    }
    
    @Bean// Here Beans are used because they specify they reflect that they are ready to use from spring application context....
    BCryptPasswordEncoder passwordEncoder() 
    {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public UserDatabaseGateway userDatabaseGateway(UserRepository userRepository) {
        return new UserDatabaseGateway(userRepository);
    }
    
    @Bean
    public AuthenticationUseCase authenticationUseCase(
    UserDatabaseGateway userDatabaseGateway,
    AuthenticationManager authenticationManager,
    BCryptPasswordEncoder PasswordEncoder) 
    {
      return new AuthenticationUseCase(userDatabaseGateway, authenticationManager, PasswordEncoder);
    }
    
    @Bean
    public CategoryDatabaseGateway categoryDatabaseGateway(CategoryRepo catRepo) {
        return new CategoryDatabaseGateway(catRepo);
    }

    
    @Bean
    public CategoryUseCase getCategoryUseCase(CategoryDatabaseGateway categoryGateway, UserDatabaseGateway userDatabaseGateway) {
      return new CategoryUseCase(categoryGateway, userDatabaseGateway);
    }

    @Bean
    AuthenticationProvider authenticationProvider() 
    {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
}