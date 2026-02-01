package com.functionalinterfaces.StaticMethodsinInterfaces;

interface UnitConverter {

    static double kmToMiles(double km) {
        return km * 0.621371;
    }

    static double kgToPounds(double kg) {
        return kg * 2.20462;
    }
}

public class UnitConversionTool {
    public static void main(String[] args) {

        double km = 10;
        double kg = 5;

        System.out.println(UnitConverter.kmToMiles(km));
        System.out.println(UnitConverter.kgToPounds(kg));
    }
}
