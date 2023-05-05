package com.workoutwarrior.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workoutwarrior.UserInfoApplication;
import com.workoutwarrior.model.User;
import com.workoutwarrior.payload.UserIdMessage;
import com.workoutwarrior.payload.UserToAdd;
import com.workoutwarrior.payload.UserToAddWithId;
import com.workoutwarrior.repo.UserRepo;

@RestController
@RequestMapping("/controller")
public class UserController {
	@Autowired UserRepo userRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(UserInfoApplication.class);
	
	
	@PostMapping("/getuser")
	public User getUser(@RequestBody UserIdMessage userId) {
		logger.info(LocalDateTime.now() + " User info is requested for user with ID: " + userId.getUserId());
		
		List<User> userList = userRepo.findByUserId(userId.getUserId());
		User user = new User();
		if (userList.size() == 1) {
			user = userList.get(0);
		}
		return user;
	}
	
	@PostMapping("/createuser")
	public UserIdMessage createUser(@RequestBody UserToAdd userToAdd) {
		logger.info(LocalDateTime.now() + " User Requested adding new user to database with name: " + userToAdd.getName());
		
		// BMI calculator
		Double userBmi = userToAdd.getWeight() / (userToAdd.getHeight() * userToAdd.getHeight() );
		// Determining weight category
		String userWeightCategory = new String();
		if (userBmi < 18.5) {
			userWeightCategory = "Underweight";
		} else if(userBmi < 25.0) {
			userWeightCategory = "Normal weight";
		} else if(userBmi < 30) {
			userWeightCategory = "Overweight";
		} else {
			userWeightCategory = "Obesity";
		}
		
		User user = userRepo.insert(new User(userToAdd.getName(), userToAdd.getAge(), userToAdd.getWeight(), userToAdd.getHeight(),
				userToAdd.getGender(), userBmi, userWeightCategory));
		
		logger.info("User added with Id: " + user.getUserId());
		
		UserIdMessage userIdMessage = new UserIdMessage(user.getUserId());
		return userIdMessage;
	}
	
	@PostMapping("/updateuser")
	public UserIdMessage updateUser(@RequestBody UserToAddWithId userToAddWithId) {
		logger.info(LocalDateTime.now() + " User Requested updating to user in the database with ID: " + userToAddWithId.getUserId());
		
		if (userRepo.findByUserId(userToAddWithId.getUserId()).size() != 1) {
			return (new UserIdMessage(""));
		}
		
		// BMI calculator
		Double userBmi = userToAddWithId.getWeight() / (userToAddWithId.getHeight() * userToAddWithId.getHeight() );
		// Determining weight category
		String userWeightCategory = new String();
		if (userBmi < 18.5) {
			userWeightCategory = "Underweight";
		} else if(userBmi < 25.0) {
			userWeightCategory = "Normal weight";
		} else if(userBmi < 30) {
			userWeightCategory = "Overweight";
		} else {
			userWeightCategory = "Obesity";
		}
		
		User user = new User(userToAddWithId.getName(), userToAddWithId.getAge(), userToAddWithId.getWeight(), userToAddWithId.getHeight(),
				userToAddWithId.getGender(), userBmi, userWeightCategory);
		user.setUserId(userToAddWithId.getUserId());
		
		// Save will update existing one since we set the same ID.
		User userUpdated = userRepo.save(user);
		
		logger.info("User updated with Id: " + userUpdated.getUserId());
		
		UserIdMessage userIdMessage = new UserIdMessage(userUpdated.getUserId());
		return userIdMessage;
	}
	
	@PostMapping("/deleteuser")
	public UserIdMessage deleteUser(@RequestBody UserIdMessage userIdMessage) {
		logger.info(LocalDateTime.now() + " User Requested deleting user in the database with ID: " + userIdMessage.getUserId());
		
		
		if (userRepo.findByUserId(userIdMessage.getUserId()).size() != 1) {
			return (new UserIdMessage(""));
		}
		
		userRepo.deleteById(userIdMessage.getUserId());
		logger.info("User deleted with Id: " + userIdMessage.getUserId());
		return userIdMessage;
	}
	
	// This Function is removed since no body has this permission
	/*
	@GetMapping("/getallusers")
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	*/
}
