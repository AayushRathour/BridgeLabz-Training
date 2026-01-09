package com.ArtifyDigitalArtMarketplace;

public abstract class Artwork implements IPurchasable  {
	String title;
	String artist;
	int price;
	protected String licenseType;
	boolean preview;
	
	public double  purchase() {
		return price;
	}
	
	Artwork(String title,String artist,int price,String licenseType){
		this.title =title;
		this.artist =artist;
		this.price =price;
		this.licenseType= licenseType;
		this.preview = false;
		
	}
	Artwork(String title,String artist,int price,String licenseType, boolean preview){
		this.title =title;
		this.artist =artist;
		this.price =price;
		this.licenseType= licenseType;
		this.preview= preview;
	}
	
	
}
