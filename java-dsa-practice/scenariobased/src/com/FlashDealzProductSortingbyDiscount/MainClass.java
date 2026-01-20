package com.FlashDealzProductSortingbyDiscount;

public class MainClass {
    public static void main(String[] args) {

        int[] Rathour = {4, 2, 52, 24, 345, 24, 3};
        int Aayush = Rathour.length;

        ProductSorter.quickSort(Rathour, 0, Aayush - 1);

        for (int i = 0; i < Aayush; i++) {
            System.out.print(Rathour[i] + " ");
        }
    }
}
