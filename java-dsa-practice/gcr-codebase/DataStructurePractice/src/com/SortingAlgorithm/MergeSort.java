package com.SortingAlgorithm;

import java.util.*;

public class MergeSort {
    static void mergeSort(int[] Aayush, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(Aayush, left, mid);
            mergeSort(Aayush, mid + 1, right);

            int[] temp = new int[right - left + 1];
            int i = left, j = mid + 1, k = 0;

            while (i <= mid && j <= right) {
                if (Aayush[i] <= Aayush[j]) {
                    temp[k++] = Aayush[i++];
                } else {
                    temp[k++] = Aayush[j++];
                }
            }

            while (i <= mid) temp[k++] = Aayush[i++];
            while (j <= right) temp[k++] = Aayush[j++];

            for (int x = 0; x < temp.length; x++) {
                Aayush[left + x] = temp[x];
            }
        }
    }

    public static void main(String[] args) {
        int[] Aayush = {450, 299, 999, 199, 750, 520};

        mergeSort(Aayush, 0, Aayush.length - 1);

        System.out.println(Arrays.toString(Aayush));
    }
}
