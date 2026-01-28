package com.annotations;

public class LegacyAPI {
	@Deprecated
    public void oldFeature() {
        System.out.println("Old feature is deprecated");
    }

    public void newFeature() {
        System.out.println("New feature should be used");
    }
    
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        api.oldFeature();
        api.newFeature();
    }
}
