package com.workoutwarrior.controller;

import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workoutwarrior.model.User;
import com.workoutwarrior.model.Workout;
import com.workoutwarrior.payload.ExerciseNote;
import com.workoutwarrior.payload.WorkoutPayload;
import com.workoutwarrior.repo.UserRepository;
import com.workoutwarrior.repo.WorkoutRepository;

import ch.qos.logback.classic.Logger;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/workout")
public class WorkoutRestController {

	@Autowired private WorkoutRepository workoutRepository;
	@Autowired private UserRepository userRepository;
	@Autowired private MongoTemplate mongoTemplate;
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(WorkoutRestController.class);

	@PostConstruct
	public void init()
	{
		if(workoutRepository.count() == 0)
		{
			logger.info("Database is empty, will be loaded!");
			
			
			User user1 = new User("Hasan Firat");
			User user2 = new User("Anıl");
			User user3 = new User("Cenker");		
			User user4 = new User("Ayşegül");	
			
			userRepository.save(user1); userRepository.save(user2); 
			userRepository.save(user3); userRepository.save(user4);
			
			
			
			ExerciseNote exercise = new ExerciseNote("Biceps curl", 3, 12);
			ExerciseNote exercise2 = new ExerciseNote("Triceps extension", 3, 12, "Arm Extension Machine");
			
			List<ExerciseNote> exToSave = new ArrayList<ExerciseNote>();
			List<ExerciseNote> exToSave_2 = new ArrayList<ExerciseNote>();
			List<ExerciseNote> exToSave_3 = new ArrayList<ExerciseNote>();

			exToSave.add(exercise); exToSave.add(exercise2);
			exToSave_2.add(exercise);
			exToSave_3.add(exercise2);
			
			Workout workout = new Workout(user1, exToSave);
			Workout workout_2 = new Workout(user2, exToSave_2);
			Workout workout_3 = new Workout(user3, exToSave_3);
			Workout workout_4 = new Workout(user4, exToSave);
			
			workoutRepository.insert(workout); workoutRepository.insert(workout_2);
			workoutRepository.insert(workout_3); workoutRepository.insert(workout_4);
			
			logger.info("Database is loaded!");
			
		}
	}
	
	/*
	@GetMapping("/getallworkouts/")
	public List<Workout> getAllWorkout(@PathVariable("name") String name)
	{
		
		Query query = new Query();
		query.addCriteria(Criteria.where("user").exists(true)).with(Sort.by(Direction.ASC, "date"));
		
		return mongoTemplate.find(query, Workout.class);
		
	}
	*/
	/*
	@PostMapping("/getallworkouts")
	public List<Workout> getAllWorkout(@RequestBody WorkoutPayload workoutpayload)
	{
		Optional<User> user = userRepository.findById(workoutpayload.getUserid());
		List<Workout> workout = workoutRepository.findByUser(user);
		return workout;	
	}
	*/
	
	@GetMapping("/getallworkouts/{id}")
	public List<Workout> getAllWorkout(@PathVariable("id") String id)
	{
		Optional<User> user = userRepository.findById(id);
		List<Workout> workout = workoutRepository.findByUser(user);
		return workout;	
	}
	
	@PostMapping("/createworkout")
	public Workout createWorkout(@RequestBody WorkoutPayload workoutpayload)
	{
		User user = new User();
		user.setId(workoutpayload.getUserid());
		
		Workout workout = new Workout(user, workoutpayload.getExercise(), LocalDateTime.now());
		workoutRepository.save(workout);
		
		return workout;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteWorkout(@PathVariable("id") String id)
	{
		workoutRepository.deleteById(id.strip());
		return "Workout \'" + id.strip() + "\' is removed!";
	}
	
}
