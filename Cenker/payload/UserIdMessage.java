package com.workoutwarrior.payload;

public class UserIdMessage {
	private String userId;

	public UserIdMessage() {
		
	}

	public UserIdMessage(String userId) {
		super();
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
