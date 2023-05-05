package com.workoutwarrior.payload;

public class UserToAddWithId {
	
	private String userId;
	private String name;
	private int age;
	private double weight;
	private double height;
	private String gender;
	
	public UserToAddWithId() {
		
	}

	public UserToAddWithId(String userId, String name, int age, double weight, double height, String gender) {
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.gender = gender;
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
	
	
	
	

}
