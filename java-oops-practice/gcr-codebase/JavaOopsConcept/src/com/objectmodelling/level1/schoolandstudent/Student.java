package com.objectmodelling.level1.schoolandstudent;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
    private List<Course> courses;
    
    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void enrollInCourse(Course course) {
            courses.add(course);
    }
    
    public void viewCourses() {
        for (Course course : courses) {
            System.out.println(" " + course.getTitle());
        }
    }
}