package com.CropMonitorSensorDataOrdering;

import java.util.*;

public class CropMonitor {
    static void quickSort(long[] time, int low, int high) {
        if (low < high) {
            int p = partition(time, low, high);
            quickSort(time, low, p - 1);
            quickSort(time, p + 1, high);
        }
    }

    static int partition(long[] time, int low, int high) {
        long pivot = time[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (time[j] < pivot) {
                i++;
                long temp = time[i];
                time[i] = time[j];
                time[j] = temp;
            }
        }

        long temp = time[i + 1];
        time[i + 1] = time[high];
        time[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        long[] timestamps = {1642, 1689, 16823, 118009};

        quickSort(timestamps, 0, timestamps.length - 1);

        System.out.println(Arrays.toString(timestamps));
    }
}
