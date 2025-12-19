import java.util.*;

public class Yongestfriend{
    public static void main(String[] args) {

        // Creating Scanner object and taking input from user
        Scanner sc = new Scanner(System.in);
        
		int[] age = new int[3];
		double[] height = new double[3];
		
		for(int i =0; i<3; i++){
			System.out.println("Enter the age and Height of 1st frd");
			height[i] = sc.nextDouble();
			age[i] = sc.nextInt();
		}
		int youngest = 0;
		int tallest = 0;
		for(int i= 0; i<3 ; i++){
			if(age[youngest] < age[i]) youngest = i;
			if(height[tallest] > height[tallest]) tallest = i;
		}
		System.out.println((youngest+1) + " is youngest");
		System.out.println((tallest+1) + " is tallest");


        sc.close();
    }
}
