package com.ArtifyDigitalArtMarketplace;

public class MainClass {
	public static void main(String[] args ) {
		User user = new User("User", 2000);
		
		Artwork ar = new PrintArt("Java","Aayush" , 100,"Premium", false);
		Artwork n  = new DigitalArt("PY","Aayush" , 1000,"Premium",true);
		
		user.showBalance();

        System.out.println(ar.licenseType);
        System.out.println(ar.purchase());
       
		user.showBalance();

        System.out.println(n.licenseType);
        System.out.println(n.purchase());

	}
}
