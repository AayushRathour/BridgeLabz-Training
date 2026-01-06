package com.FitTrackYourPersonalFitnessTracker;

public class StrengthWorkout extends Workout {

    StrengthWorkout(int duration) {
        super("Strength", duration);
    }

    int calculateCalories() {
        return duration * 6;
    }
}
