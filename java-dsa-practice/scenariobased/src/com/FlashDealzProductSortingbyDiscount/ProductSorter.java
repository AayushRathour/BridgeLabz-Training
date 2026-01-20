package com.FlashDealzProductSortingbyDiscount;

public class ProductSorter {

    public static void quickSort(int[] Rathour, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(Rathour, low, high);
            quickSort(Rathour, low, pivotIndex - 1);
            quickSort(Rathour, pivotIndex + 1, high);
        }
    }

    static int partition(int[] Rathour, int low, int high) {
        int pivot = Rathour[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (Rathour[j] > pivot) {
                i++;
                int temp = Rathour[i];
                Rathour[i] = Rathour[j];
                Rathour[j] = temp;
            }
        }

        int temp = Rathour[i + 1];
        Rathour[i + 1] = Rathour[high];
        Rathour[high] = temp;

        return i + 1;
    }
}
