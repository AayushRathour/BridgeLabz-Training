package com.SmartHomeAutomationSystem;

public class User {
    private int userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public void displayUser() {
        System.out.println("User Id : " + userId + " Name : " + name);
    }
}