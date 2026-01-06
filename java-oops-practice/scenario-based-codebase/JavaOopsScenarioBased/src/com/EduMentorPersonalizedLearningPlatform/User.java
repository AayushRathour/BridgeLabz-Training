package com.EduMentorPersonalizedLearningPlatform;

public class User {
	String name;
	String email;
	private int userid;
	
	User(String name, String email, int userid){
		this.name = name;
		this.email = email;
		this.userid =userid;
		
	}
	String getName() {
		return name;
	}
	String getEmail() {
		return name;
	}
	public void displayData() {
		System.out.println(name + "|" +email+"|"+userid);
	}
}
