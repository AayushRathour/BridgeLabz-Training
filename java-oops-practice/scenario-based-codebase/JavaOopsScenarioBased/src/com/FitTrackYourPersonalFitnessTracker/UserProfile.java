package com.FitTrackYourPersonalFitnessTracker;

public class UserProfile {
    String name;
    int age;
    private int weight;      // private health data
    String goal;

    UserProfile(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.goal = "Stay Fit";   // default goal
    }

    UserProfile(String name, int age, int weight, String goal) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.goal = goal;
    }

    int getWeight() {
        return weight;
    }
}
