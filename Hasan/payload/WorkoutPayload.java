package com.workoutwarrior.payload;

import java.time.LocalDateTime;
import java.util.List;

public class WorkoutPayload {

	private String userid;
	private List<ExerciseNote> exercise;
	private LocalDateTime date;	
	
	public WorkoutPayload() {
		// TODO Auto-generated constructor stub
	}
	
	
	public WorkoutPayload(String userid, List<ExerciseNote> exercise, LocalDateTime date) {
		super();
		this.userid = userid;
		this.exercise = exercise;
		this.date = date;
	}
	 

	public WorkoutPayload(String userid, List<ExerciseNote> exercise) {
		super();
		this.userid = userid;
		this.exercise = exercise;
		this.date = LocalDateTime.now();
	}



	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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
	
	
}
