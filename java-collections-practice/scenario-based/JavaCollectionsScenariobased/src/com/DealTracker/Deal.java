package com.DealTracker;

import java.time.*;

public class Deal extends Promotion {

    int discount;
    LocalDate validTill;
    int minPurchase;

    Deal(String code, int discount, LocalDate validTill, int minPurchase) {
        this.code = code;
        this.discount = discount;
        this.validTill = validTill;
        this.minPurchase = minPurchase;
    }

    public String toString() {
        return code + " | " + discount + "% | " + validTill + " | Min: " + minPurchase;
    }
}
