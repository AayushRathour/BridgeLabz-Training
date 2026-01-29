package com.DealTracker;

import java.util.*;

public class MainClass {

    public static void main(String[] args) throws Exception {

        DealParser parser = new DealParser();
        DealRepository repo = new DealRepository();
        DealSorter sorter = new DealSorter();

        List<Deal> parsedDeals = parser.parseFile("deal.txt");

        repo.addDeals(parsedDeals);

        List<Deal> sortedDeals =
                sorter.sortByDiscount(repo.getAllDeals());

        for (Deal d : sortedDeals) {
            System.out.println(d);
        }
    }
}
