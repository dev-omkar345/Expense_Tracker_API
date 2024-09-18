package com.example.Track_Api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.example.Track_Api.infrastructureanddatabase")
//@EntityScan(basePackages = "com.example.Track_Api.domain")
public class TrackApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackApiApplication.class, args);
	}
}
