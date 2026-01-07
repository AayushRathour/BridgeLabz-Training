package com.SortingAlgorithm;

import java.util.*;

public class CountingSort{
    public static void main(String[] args) {

        int[] ages = {12, 15, 11, 18, 14, 10, 12, 16};

        int min = 10;
        int max = 18;

        int[] cnt = new int[max - min + 1];

        for (int a : ages) {
            cnt[a - min]++;
        }

        for (int i = 1; i < cnt.length; i++) {
            cnt[i] = cnt[i] + cnt[i - 1];
        }

        int[] res = new int[ages.length];

        for (int i = ages.length - 1; i >= 0; i--) {
            int a = ages[i];
            int pos = cnt[a - min] - 1;
            res[pos] = a;
            cnt[a - min]--;
        }

        System.out.println(Arrays.toString(res));
    }
}
