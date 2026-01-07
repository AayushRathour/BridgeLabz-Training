package com.SortingAlgorithm;

import java.util.*;

public class SelectionSort{
    public static void main(String[] args) {

        int[] scores = {72, 88, 45, 91, 60, 79};

        for (int i = 0; i < scores.length - 1; i++) {

            int min = i;

            for (int j = i + 1; j < scores.length; j++) {
                if (scores[j] < scores[min]) {
                    min = j;
                }
            }

            int tmp = scores[i];
            scores[i] = scores[min];
            scores[min] = tmp;
        }

        System.out.println(Arrays.toString(scores));
    }
}
