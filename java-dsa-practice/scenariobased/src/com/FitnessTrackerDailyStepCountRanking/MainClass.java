package com.FitnessTrackerDailyStepCountRanking;

public class MainClass {
    public static void main(String[] args) {

        int[] dailySteps = {8420, 12500, 6400, 9800, 15000, 7200};
        int totalUsers = dailySteps.length;

        StepSorter.bubbleSort(dailySteps);

        for (int i = 0; i < totalUsers; i++) {
            System.out.print(dailySteps[i] + " ");
        }
    }
}
