package com.FoodFestSortingStallsbyCustomerFootfall;

public class MainClass {
    public static void main(String[] args) {

        int[] stallFootfall = {120, 150, 150, 200, 90, 100, 180};

        FootfallMerger.mergeSort(stallFootfall, 0, stallFootfall.length - 1);

        for (int i = 0; i < stallFootfall.length; i++) {
            System.out.print(stallFootfall[i] + " ");
        }
    }
}
