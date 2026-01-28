package com.annotations.cachingsystem;


public class TestCahceMethod {
	public static void main(String[] args) throws Exception {
		Methods method = new Methods();
		
		System.out.println(CacheSystem.invoke(method, "testMethod", "Parameter"));
		System.out.println(CacheSystem.invoke(method, "testMethod", "Parameter"));
		System.out.println(CacheSystem.invoke(method, "testMethod", "Parameter"));
	}
}
