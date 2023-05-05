package com.workoutwarrior.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.workoutwarrior.model.User;

public interface UserRepo extends MongoRepository<User, String>{
	
	public List<User> findByUserId(String userId);

}
