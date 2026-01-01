package com.inheritance.singleinheritance.smarthomedevices;

public class DriverClass {
	public static void main(String[] args) {

		Thermostat thermostat = new Thermostat(0, "ON", 30);
	    thermostat.displayStatus();
	}
}