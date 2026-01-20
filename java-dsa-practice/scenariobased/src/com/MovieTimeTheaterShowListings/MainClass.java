package com.MovieTimeTheaterShowListings;


public class MainClass {
    public static void main(String[] args) {

        int[] showTimes = {900, 1030, 1200, 1500, 1800, 2200, 2000};

        ShowTimeSorter.insertionSort(showTimes);

        for (int i = 0; i < showTimes.length; i++) {
            System.out.print(showTimes[i] + " ");
        }
    }
}
