package com.SearchingAlgorithm.BinarySearch;

import java.util.Arrays;

public class CompareSearchingAlgorithm {
    private static int firstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean[] present = new boolean[n + 1];

        for (int num : arr) {
            present[num] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (!present[i]) return i;
        }

        return n + 1;
    }

    private static int binarySearch(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 0, 3, 5, 6};
        int target = 4;

        // ----- Linear Search Timing -----
        long timer = System.nanoTime();
        int missing = firstMissingPositive(arr);

        System.out.println("Linear Search Time : " + (System.nanoTime() - timer));

        Arrays.sort(arr);

        timer = System.nanoTime();
        int index = binarySearch(target, arr);

        System.out.println("Binary Search Time : " + (System.nanoTime() - timer));
    }
}