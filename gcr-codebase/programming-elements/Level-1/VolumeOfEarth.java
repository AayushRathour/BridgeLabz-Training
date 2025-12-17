public class VolumeOfEarth{
	public static void main(String[] args){
	
		// This is the  radius of earth in km
		int redius = 6378;
		
		// Finding the Volume of a Earth using the formula 
		double volume = (4/3) * 3.14 * redius*redius*redius;
		
		// Finding the Value in miles
		double Miles = redius*0.6;
		
		double volumeMiles = (4.0 / 3.0) * 3.14 * Miles * Miles * Miles;
		

		System.out.println("The volume of earth in cubic kilometers is " +volume + "and cubic miles is" + volumeMiles);

		
		
		
	}
}