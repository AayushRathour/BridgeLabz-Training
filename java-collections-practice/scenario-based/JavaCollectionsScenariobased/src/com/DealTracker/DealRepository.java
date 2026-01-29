package com.DealTracker;

import java.util.*;

public class DealRepository {

    Map<String, Deal> dealMap = new HashMap<>();
    Set<String> dealCodes = new HashSet<>();

    public void addDeals(List<Deal> deals) {

        for (Deal d : deals) {

            if (dealCodes.contains(d.code)) continue;

            dealCodes.add(d.code);
            dealMap.put(d.code, d);
        }
    }

    public Collection<Deal> getAllDeals() {
        return dealMap.values();
    }
}
