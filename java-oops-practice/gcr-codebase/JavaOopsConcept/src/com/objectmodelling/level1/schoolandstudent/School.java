package com.objectmodelling.level1.schoolandstudent;

import java.util.ArrayList;

public class School {
	private String name;
	ArrayList<Course> courses;
	
	// constructor
	public School(String name) {
		this.name = name;
		courses = new ArrayList<Course>();
	}
	
	// method to add course
	public void addCouse(Course course) {
		courses.add(course);
	}

	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
