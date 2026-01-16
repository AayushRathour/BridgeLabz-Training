package com.ExamCellStudentRankGenerator;

import java.util.*;

public class ExamCell {

    static int[] merge(int[] a, int[] b) {

        int[] ans = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] >= b[j]) {
                ans[k++] = a[i++];
            } else {
                ans[k++] = b[j++];
            }
        }

        while (i < a.length) ans[k++] = a[i++];
        while (j < b.length) ans[k++] = b[j++];

        return ans;
    }

    public static void main(String[] args) {

        int[] center1 = {95, 90, 85};
        int[] center2 = {96, 92, 88};

        int[] rankList = merge(center1, center2);

        System.out.println(Arrays.toString(rankList));
    }
}
