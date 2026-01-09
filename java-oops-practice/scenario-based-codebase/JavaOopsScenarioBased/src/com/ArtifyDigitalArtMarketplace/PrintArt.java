package com.ArtifyDigitalArtMarketplace;

public class PrintArt extends Artwork{

	PrintArt(String title, String artist, int price, String licenseType, boolean preview) {
		super(title, artist, price, licenseType, preview);
		
	}
	PrintArt(String title, String artist, int price, String licenseType) {
		super(title, artist, price, licenseType);
		
	}
	@Override
	public void license() {
		licenseType = "Lisence for printing";
		
		
		
	}

	
}
