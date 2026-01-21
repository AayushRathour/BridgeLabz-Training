package com.MedWarehouseSortingMedicinesbyExpiry;


import java.util.*;

public class MainClass {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] expiry = new int[10];

        System.out.println("Enter expiry days of medicines");
        for (int i = 0; i < 10; i++) {
            expiry[i] = sc.nextInt();
        }

        MedWarehouse mw = new MedWarehouse();
        mw.mergeSort(expiry, 0, expiry.length - 1);

        System.out.println("Sorted Expiry List : " + Arrays.toString(expiry));

        System.out.println("Medicines nearing expiry (≤ 30 days):");
        for (int i = 0; i < expiry.length; i++) {
            if (expiry[i] <= 30)
                System.out.print(expiry[i] + " ");
        }
    }
}
