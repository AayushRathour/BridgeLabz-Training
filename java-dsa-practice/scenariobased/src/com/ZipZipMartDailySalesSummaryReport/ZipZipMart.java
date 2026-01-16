package com.ZipZipMartDailySalesSummaryReport;

import java.util.*;

public class ZipZipMart {
    static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);

        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        for (int x = 0; x < temp.length; x++)
            arr[l + x] = temp[x];
    }

    public static void main(String[] args) {
        int[] sales = {450, 1200, 300, 1200, 700};
        mergeSort(sales, 0, sales.length - 1);
        System.out.println(Arrays.toString(sales));
    }
}
