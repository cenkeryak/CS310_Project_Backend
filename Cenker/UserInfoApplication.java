package com.workoutwarrior;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.workoutwarrior.repo.UserRepo;
import com.workoutwarrior.model.User;

@SpringBootApplication
public class UserInfoApplication implements CommandLineRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(UserInfoApplication.class);
	
	@Autowired UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(UserInfoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		
		
		
	}

	
}
