package com.CampusConnectCollegeInformationSystem;

public class Faculty extends Person {

    Faculty(String name, String email, int id) {
        super(name, email, id);
    }

    void printDetails() {
        System.out.println("Faculty Name: " + name);
    }
}
