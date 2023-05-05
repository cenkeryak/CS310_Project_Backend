package com.workoutwarrior.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Users")
public class User {
	
	@Id private String userId;
	
	private String name;
	private int age;
	private double weight;
	private double height;
	private String gender;
	private double bmi;
	private String weightCategory;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(String name, int age, double weight, double height, String gender, double bmi, String weightCategory) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.gender = gender;
		this.bmi = bmi;
		this.weightCategory = weightCategory;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public double getBmi() {
		return bmi;
	}


	public void setBmi(double bmi) {
		this.bmi = bmi;
	}


	public String getWeightCategory() {
		return weightCategory;
	}


	public void setWeightCategory(String weightCategory) {
		this.weightCategory = weightCategory;
	}
	
	
	
	

}
