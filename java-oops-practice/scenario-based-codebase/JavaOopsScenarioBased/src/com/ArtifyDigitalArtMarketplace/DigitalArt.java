package com.ArtifyDigitalArtMarketplace;

public class DigitalArt extends Artwork {

	DigitalArt(String title, String artist, int price, String licenseType, boolean preview) {
		super(title, artist, price, licenseType, preview);
		
	}
	DigitalArt(String title, String artist, int price, String licenseType) {
		super(title, artist, price, licenseType);
		
	}

	public void license() {
		licenseType =" Digital Lisence";
	}

}
