package com.SortingAlgorithm;

import java.util.*;

public class QuickSort{

    static int partition(int[] Aayush, int low, int high) {
        int Rathour = Aayush[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (Aayush[j] < Rathour) {
                i++;
                int temp = Aayush[i];
                Aayush[i] = Aayush[j];
                Aayush[j] = temp;
            }
        }

        int temp = Aayush[i + 1];
        Aayush[i + 1] = Aayush[high];
        Aayush[high] = temp;

        return i + 1;
    }

    static void quickSort(int[] Aayush, int low, int high) {
        if (low < high) {
            int pi = partition(Aayush, low, high);
            quickSort(Aayush, low, pi - 1);
            quickSort(Aayush, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] Aayush = {1200, 450, 999, 300, 1500, 700};

        quickSort(Aayush, 0, Aayush.length - 1);

        System.out.println(Arrays.toString(Aayush));
    }
}
