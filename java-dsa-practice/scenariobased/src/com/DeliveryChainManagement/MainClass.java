package com.DeliveryChainManagement;

public class MainClass {
    public static void main(String[] args) {

        Status parcel = new Status();

        parcel.addStage("Packed");
        parcel.addStage("Shipped");
        parcel.addStage("In Transit");
        parcel.addStage("Delivered");

        parcel.addAfter("Shipped", "Custom Checkpoint");

        parcel.track();
    }
}
