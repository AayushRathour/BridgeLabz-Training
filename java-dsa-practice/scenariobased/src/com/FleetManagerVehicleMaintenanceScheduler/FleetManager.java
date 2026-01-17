package com.FleetManagerVehicleMaintenanceScheduler;

import java.util.*;

public class FleetManager {
    public static void main(String[] args) {
        int[] depotA = {12000, 25000, 40000};
        int[] depotB = {15000, 30000, 45000};

        int[] master = new int[depotA.length + depotB.length];

        int i = 0, j = 0, k = 0;

        while (i < depotA.length && j < depotB.length) {
            if (depotA[i] < depotB[j]) {
                master[k++] = depotA[i++];
            } else {
                master[k++] = depotB[j++];
            }
        }

        while (i < depotA.length) {
            master[k++] = depotA[i++];
        }

        while (j < depotB.length) {
            master[k++] = depotB[j++];
        }

        System.out.println(Arrays.toString(master));
    }
}
