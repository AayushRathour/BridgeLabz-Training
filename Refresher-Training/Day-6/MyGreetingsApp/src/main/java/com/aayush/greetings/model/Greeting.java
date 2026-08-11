package com.aayush.greetings.model;

public class Greeting {

    private int id;
    private String name;
    private int userId;

    public Greeting() {}

    public Greeting(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}
