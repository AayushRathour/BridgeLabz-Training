public class UnitConverter3{
	// convert farhenheit to celsius 
	public static double convertFarhenheitToCelsius(double farhenheit) {
       return (farhenheit - 32) * 5 / 9;
    }

    // celsius to farhenheit
    public static double convertCelsiusToFarhenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // pounds to kilograms
    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    // kilograms to pounds
    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }
	
	// gallons to liters 
    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }
	
	// liters to gallons = 0.264172; 
    public static double convertLitersToGallons(double liters) {
        return liters * 2.54;
    }
}