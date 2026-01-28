package com.annotations.cachingsystem;

public class Methods {
	@CacheResult
	public int testMethod(String s) {
		System.out.println("Method called");
		return s.length();
	}
}
