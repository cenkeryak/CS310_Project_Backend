package com.workoutwarrior.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.workoutwarrior.payload.ExerciseNote;

@Document("workout")
public class Workout {

	@Id
	private String id;		//MondoDB attributed unique ID
	
	@DBRef
	private User user;		//Refers to the client/user class
	
	private List<ExerciseNote> exercise;	//The exercises(moves) that are done by the user
	private LocalDateTime date;				//Date of that workout
	
	
	public Workout() {
		// TODO Auto-generated constructor stub
	}


	public Workout(User user, List<ExerciseNote> exercise, LocalDateTime date) {
		super();
		this.user = user;
		this.exercise = exercise;
		this.date = date;
	}

	
	
	public Workout(User user, List<ExerciseNote> exercise) {
		super();
		this.user = user;
		this.exercise = exercise;
		this.date = LocalDateTime.now();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<ExerciseNote> getExercise() {
		return exercise;
	}


	public void setExercise(List<ExerciseNote> exercise) {
		this.exercise = exercise;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Workout [id=" + id + ", user=" + user + ", exercise=" + exercise + ", date=" + date + "]";
	}
	
	
}
