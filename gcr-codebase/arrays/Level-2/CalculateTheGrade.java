import java.util.*;

public class CalculateTheGrade{
	public static void main(String[] args){
		// Creating Scanner Object and initializing array
     
        Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of students : ");
		int n = sc.nextInt();
		int[] physics = new int[n];
		int[] chemistry = new int[n];
		int[] maths = new int[n];
		double[] percentage = new double[n];
		char[] grade = new char[n];
		
		// taking input
		for(int i = 0; i < n; i++){
			System.out.print("Enter marks of physics, chemistry and maths : ");
			int currPhysics = sc.nextInt();
			int currChemistry = sc.nextInt();
			int currMaths = sc.nextInt();
			
			while(currPhysics < 0 || currChemistry < 0 || currMaths < 0){
				System.out.println("Enter non negative marks for all 3 subjects : ");
				currPhysics = sc.nextInt();
				currChemistry = sc.nextInt();
				currMaths = sc.nextInt();
			}
			physics[i] = currPhysics;
			chemistry[i] = currChemistry;
			maths[i] = currMaths;
		}
		
		// calculating percentage and grade
		for(int i = 0; i < n; i++){
			double total = physics[i] + chemistry[i] + maths[i];
			double currPercentage = total / 3;
			percentage[i] = currPercentage;
			
			if (percentage[i] >= 80) {
				grade[i] = 'A';
			}
			else if (percentage[i] >= 70) {
				grade[i] = 'B';
			}
			else if (percentage[i] >= 60) {
				grade[i] = 'C';
			}
			else if (percentage[i] >= 50) {
				grade[i] = 'D';
			}
			else if (percentage[i] >= 40) {
				grade[i] = 'E';
			}
			else {
				grade[i] = 'R';
			}
		}
		
		// displayint total marks, percentage and grade
		for(int i = 0; i < n; i++){
			System.out.println("Physics : " + physics[i] + ", Chemistry : " + chemistry[i] + ", Maths : " + maths[i] + ", Percentage : " + percentage[i] + ", Grade : " + grade[i]);
		}
		
		// Scanner Closed 
		sc.close();
		
	}	
}