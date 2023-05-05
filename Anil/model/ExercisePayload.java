package com.workoutwarrior.model;

public class ExercisePayload {
	private String name;
	private String type;
	private String muscle;
	private String equipment;
	private String difficulty;
	
	
	
	
	
	public ExercisePayload() {
		super();
	}





	public ExercisePayload(String name, String type, String muscle, String equipment, String difficulty) {
		super();
		this.name = name;
		this.type = type;
		this.muscle = muscle;
		this.equipment = equipment;
		this.difficulty = difficulty;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getType() {
		return type;
	}





	public void setType(String type) {
		this.type = type;
	}





	public String getMuscle() {
		return muscle;
	}





	public void setMuscle(String muscle) {
		this.muscle = muscle;
	}





	public String getEquipment() {
		return equipment;
	}





	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}





	public String getDifficulty() {
		return difficulty;
	}





	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	
}
