package com.workoutwarrior.repo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.workoutwarrior.model.User;
import com.workoutwarrior.model.Workout;
import com.workoutwarrior.payload.ExerciseNote;

public interface WorkoutRepository extends MongoRepository<Workout, String>{

	public List<Workout> findByUser(Optional<User> user);
}
