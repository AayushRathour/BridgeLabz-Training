package com.FoodFestSortingStallsbyCustomerFootfall;


public class FootfallMerger {

    public static void mergeSort(int[] footfall, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(footfall, left, mid);
            mergeSort(footfall, mid + 1, right);

            merge(footfall, left, mid, right);
        }
    }

    static void merge(int[] footfall, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArr[i] = footfall[left + i];

        for (int j = 0; j < n2; j++)
            rightArr[j] = footfall[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                footfall[k] = leftArr[i];
                i++;
            } else {
                footfall[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            footfall[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            footfall[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
