package com.FitTrackYourPersonalFitnessTracker;

public class MainClass {
    public static void main(String[] args) {

        UserProfile user = new UserProfile("Aayush", 21, 70, "Weight Loss");

        Workout w1 = new CardioWorkout(30);
        Workout w2 = new StrengthWorkout(20);

        Workout[] workouts = {w1, w2};

        FitnessTracker tracker = new FitnessTracker(workouts, 500);

        w1.startWorkout();
        w2.startWorkout();

        tracker.showProgress();
    }
}
