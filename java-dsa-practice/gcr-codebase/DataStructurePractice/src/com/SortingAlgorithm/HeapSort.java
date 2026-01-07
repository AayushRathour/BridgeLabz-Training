package com.SortingAlgorithm;

import java.util.*;

public class HeapSort{
    
    static void heapify(int[] sal, int n, int i) {
        int max = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && sal[l] > sal[max]) max = l;
        if (r < n && sal[r] > sal[max]) max = r;

        if (max != i) {
            int tmp = sal[i];
            sal[i] = sal[max];
            sal[max] = tmp;
            heapify(sal, n, max);
        }
    }

    static void heapSort(int[] sal) {
        int n = sal.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(sal, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int tmp = sal[0];
            sal[0] = sal[i];
            sal[i] = tmp;
            heapify(sal, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] sal = {45000, 30000, 70000, 50000, 60000};

        heapSort(sal);

        System.out.println(Arrays.toString(sal));
    }
}
