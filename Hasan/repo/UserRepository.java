package com.workoutwarrior.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.workoutwarrior.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
