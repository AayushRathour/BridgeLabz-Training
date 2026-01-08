package com.SearchingAlgorithm.BinarySearch;

public class FirstAndLastOccurrence {
    private static int findFirst(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                ans = mid;
                right = mid - 1;
            } 
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return ans;
    }

    private static int findLast(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                ans = mid;
                left = mid + 1;
            } 
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;

        int first = findFirst(target, arr);
        int last = findLast(target, arr);

        if (first == -1)  System.out.println("Element not found");
        else {
            System.out.println("First Occurrence Index: " + first);
            System.out.println("Last Occurrence Index: " + last);
        }
    }
}