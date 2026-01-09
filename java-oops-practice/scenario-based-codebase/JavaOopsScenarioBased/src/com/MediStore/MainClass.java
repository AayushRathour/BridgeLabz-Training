package com.MediStore;

public class MainClass {

		public static void main(String[] args) {

			Medicine m1 = new Tablet("Paracetamol", 20, 2026, 50);
			Medicine m2 = new Syrup("Cough Syrup", 80, 2025, 20);

			m1.sell(5);
			System.out.println("Final Price: " + m1.applyDiscount(5));
			m1.checkExpiry();

			m2.sell(2);
			m2.checkExpiry();
		}
	

}
