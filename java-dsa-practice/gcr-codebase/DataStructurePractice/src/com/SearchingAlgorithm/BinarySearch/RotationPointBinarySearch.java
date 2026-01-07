package com.SearchingAlgorithm.BinarySearch;

import java.util.*;

public class RotationPointBinarySearch {
    public static void main(String[] args) {
        int[] Aayush = {7, 9, 11, 12, 5};

        int left = 0;
        int right = Aayush.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (Aayush[mid] > Aayush[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println("Rotation Point Index = " + left);
        System.out.println("Smallest Element = " + Aayush[left]);
    }
}
