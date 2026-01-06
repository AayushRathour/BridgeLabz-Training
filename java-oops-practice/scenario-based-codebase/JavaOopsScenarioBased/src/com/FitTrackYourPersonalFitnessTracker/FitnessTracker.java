package com.FitTrackYourPersonalFitnessTracker;

public class FitnessTracker {
    private Workout[] workoutLog;   // restricted access
    private int dailyTarget;

    FitnessTracker(Workout[] workoutLog, int dailyTarget) {
        this.workoutLog = workoutLog;
        this.dailyTarget = dailyTarget;
    }

    void showProgress() {
        int totalBurned = 0;

        for (Workout w : workoutLog) {
            totalBurned = totalBurned + w.calculateCalories();
        }

        System.out.println("Calories Remaining: " + (dailyTarget - totalBurned));
    }
}
