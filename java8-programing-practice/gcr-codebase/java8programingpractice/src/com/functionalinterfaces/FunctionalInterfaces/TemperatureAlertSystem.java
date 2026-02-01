package com.functionalinterfaces.FunctionalInterfaces;

import java.util.function.Predicate;

public class TemperatureAlertSystem {
    public static void main(String[] args) {

        double temperature = 42.5;
        double threshold = 40.0;

        Predicate<Double> isHighTemp = t -> t > threshold;

        if(isHighTemp.test(temperature)) {
            System.out.println("Alert: Temperature crossed limit!");
        } else {
            System.out.println("Temperature is normal.");
        }
    }
}
