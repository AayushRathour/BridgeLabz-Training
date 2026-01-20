package com.MovieTimeTheaterShowListings;


public class ShowTimeSorter {

    public static void insertionSort(int[] showTimes) {
        int n = showTimes.length;

        for (int i = 1; i < n; i++) {
            int key = showTimes[i];
            int j = i - 1;

            while (j >= 0 && showTimes[j] > key) {
                showTimes[j + 1] = showTimes[j];
                j--;
            }

            showTimes[j + 1] = key;
        }
    }
}
