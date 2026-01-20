package com.GamerZoneHighScoreRankingSystem;


public class ScoreSorter {

    public static void quickSort(int[] scores, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(scores, low, high);
            quickSort(scores, low, pivotIndex - 1);
            quickSort(scores, pivotIndex + 1, high);
        }
    }

    static int partition(int[] scores, int low, int high) {
        int pivot = scores[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (scores[j] > pivot) {
                i++;
                int temp = scores[i];
                scores[i] = scores[j];
                scores[j] = temp;
            }
        }

        int temp = scores[i + 1];
        scores[i + 1] = scores[high];
        scores[high] = temp;

        return i + 1;
    }
}
