package com.IceCreamRushSortingFlavorsbyPopularity;

public class Flavor {
	String flavor;
	int sold;
	
	public Flavor(String flavor, int sold) {
		super();
		this.flavor = flavor;
		this.sold = sold;
	}
	
	public String toString() {
		return flavor + " " + sold;
	}
}