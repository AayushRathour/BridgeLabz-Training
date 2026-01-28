package com.annotations.customserialization;

public class User {
	@JsonField(name = "user_name")
	String username;
	
	@JsonField(name = "user_age")
	int age;
	
	public User(String username, int age) {
		this.username = username;
		this.age = age;
	}
}
