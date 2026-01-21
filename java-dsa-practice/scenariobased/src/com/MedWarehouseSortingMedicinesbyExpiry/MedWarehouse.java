package com.MedWarehouseSortingMedicinesbyExpiry;


import java.util.*;

public class MedWarehouse {

    void mergeSort(int[] expiry, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(expiry, left, mid);
            mergeSort(expiry, mid + 1, right);

            merge(expiry, left, mid, right);
        }
    }

    void merge(int[] expiry, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = expiry[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = expiry[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                expiry[k] = L[i];
                i++;
            } else {
                expiry[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            expiry[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            expiry[k] = R[j];
            j++;
            k++;
        }
    }
}
