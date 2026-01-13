package com.CustomerQueueManager;

import java.util.Objects;

public class Customer {
	String name;
	boolean isSpecial;
	
	public Customer(String name, boolean isSpecial) {
		this.name = name;
		this.isSpecial = isSpecial;
	}
	
	public int hashCode() {
		return Objects.hash(name, isSpecial);
	}
	
	public boolean equals(Object object) {
		Customer customer = (Customer) object;
		if(!customer.name.equals(this.name) || customer.isSpecial != this.isSpecial) return false;
		return true;
	}
	
	public String toString() {
		return name + " " + isSpecial + " ";
				
	}
}