package com.FitTrackYourPersonalFitnessTracker;

public class CardioWorkout extends Workout {

    CardioWorkout(int duration) {
        super("Cardio", duration);
    }

    int calculateCalories() {
        return duration * 8;   // higher burn
    }
}
