package com.annotations;

import java.lang.reflect.Field;

public class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        validate(username);
        this.username = username;
    }

    private void validate(String username) {
        try {
            Field field = this.getClass().getDeclaredField("username");
            MaxLength maxLength = field.getAnnotation(MaxLength.class);

            if (maxLength != null && username.length() > maxLength.value()) {
                throw new IllegalArgumentException("Username length exceeds " + maxLength.value());
            }
        } 
        catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) {
        new User("Tarun");
        new User("VeryLongUsername");
    }
}