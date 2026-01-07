package com.EventEaseEventManagementPlatform;

public class User {
    private String name;
    private String email;   // sensitive

    User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    String getName() {
        return name;
    }
}
