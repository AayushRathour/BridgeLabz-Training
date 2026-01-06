package com.FitTrackYourPersonalFitnessTracker;

public class Workout implements Trackable{
    String type;
    int duration;        // minutes
    int caloriesBurned;

    Workout(String type, int duration) {
        this.type = type;
        this.duration = duration;
    }

    int calculateCalories() {
        return duration * 5;   // base logic
    }

    public void startWorkout() {
        System.out.println(type + " workout started");
    }

    public void stopWorkout() {
        System.out.println(type + " workout stopped");
    }
}
