package com.constructor.level1;

public class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    public HotelBooking() {
        guestName = "Unknown";
        roomType = "Standard";
        nights = 0;
    }

    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public HotelBooking(HotelBooking b1) {
        this.guestName = b1.guestName;
        this.roomType = b1.roomType;
        this.nights = b1.nights;
    }

    public static void main(String[] args) {
        HotelBooking b1 = new HotelBooking();
        HotelBooking b2 = new HotelBooking("Guest1", "Deluxe", 5);
        HotelBooking b3 = new HotelBooking(b2);

        System.out.println(b1.guestName + " " + b1.roomType + " " + b1.nights);
        System.out.println(b2.guestName + " " + b2.roomType + " " + b2.nights);
        System.out.println(b3.guestName + " " + b3.roomType + " " + b3.nights);
    }
}
