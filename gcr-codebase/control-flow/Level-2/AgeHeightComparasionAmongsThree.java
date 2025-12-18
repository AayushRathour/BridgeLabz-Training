import java.util.*;
public class AgeHeightComparasionAmongsThree{

    public static void main(String[] args) {
	
        // Creatint Scanner object and taking input from user 
        Scanner sc = new Scanner(System.in);
		System.out.print("Enter age and height of Amar : ");
        int age1 = sc.nextInt();
		double height1 = sc.nextDouble();
		System.out.print("Enter age and height of Akbar : ");
        int age2 = sc.nextInt();
		double height2 = sc.nextDouble();
		System.out.print("Enter age and height of Anthony : ");
        int age3 = sc.nextInt();
		double height3 = sc.nextDouble();
		
		// finding the youngest using if else and printing the result
		if(age1 < age2 && age1 < age3) System.out.println("Amar is youngest");
		else if(age2 < age1 && age2 < age3) System.out.println("Akbar is youngest");
		else System.out.println("Anthony is youngest");
		
		// finding the tall using if else and printing result
		if(height1 < height2 && height1 < height3) System.out.println("Amar is tallest");
		else if(height2 < height1 && height2 < height1) System.out.println("Akbar is tallest");
		else System.out.println("Anthony is tallest");
		
    }
}