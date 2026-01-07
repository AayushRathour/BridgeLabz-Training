package com.SortingAlgorithm;

import java.util.*;

public class BubbleSort{
    public static void main(String[] args) {
        int[] Aayush = {78, 45, 90, 66, 82, 50};

        for (int Aay = 0; Aay < Aayush.length - 1; Aay++) {
            boolean Rathour = false;

            for (int i = 0; i < Aayush.length - 1 - Aay; i++) {
                if (Aayush[i] > Aayush[i + 1]) {
                    int temp = Aayush[i];
                    Aayush[i] = Aayush[i + 1];
                    Aayush[i + 1] = temp;
                    Rathour = true;
                }
            }

            if (!Rathour) {
                break;
            }
        }

        System.out.println(Arrays.toString(Aayush));
    }
}
