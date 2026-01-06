package com.CampusConnectCollegeInformationSystem;

public class Person {

	    protected String name;
	    protected String email;
	    protected int id;

	    Person(String name, String email, int id) {
	        this.name = name;
	        this.email = email;
	        this.id = id;
	    }

	    void printDetails() {
	        System.out.println(name + " " + email + " " + id);
	    }
	

}