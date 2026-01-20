package com.FitnessTrackerDailyStepCountRanking;


public class StepSorter {
    public static void bubbleSort(int[] steps) {
        int n = steps.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (steps[j] < steps[j + 1]) {
                    int temp = steps[j];
                    steps[j] = steps[j + 1];
                    steps[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
