package com.Regex;

public class ValidateLicensePlate {
	private static boolean validateLicensePlateNumber(String plateNumber) {
		return plateNumber.matches("^[A-Z]{2}[0-9]{4}$");
	}
	public static void main(String[] args) {
		System.out.println(validateLicensePlateNumber("AB1234"));
		System.out.println(validateLicensePlateNumber("A01234"));
	}
}