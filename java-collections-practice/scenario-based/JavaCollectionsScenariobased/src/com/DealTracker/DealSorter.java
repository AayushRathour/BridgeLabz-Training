package com.DealTracker;

import java.util.*;

public class DealSorter {

    public List<Deal> sortByDiscount(Collection<Deal> deals) {

        List<Deal> list = new ArrayList<>(deals);

        Collections.sort(list, new Comparator<Deal>() {
            public int compare(Deal a, Deal b) {
                return b.discount - a.discount;
            }
        });

        return list;
    }
}
