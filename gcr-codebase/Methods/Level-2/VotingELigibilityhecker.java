import java.util.*;


public class VotingELigibilityhecker{
	public static boolean canStudentVote(int age){
		return age >= 18;
	}
	
	public static void main(String[] args){
		// creating scanner object and initializing array
		Scanner sc = new Scanner(System.in);
		int[] ages = new int[10];
		
		// taking input from user 
		for(int i = 0; i < 10; i++){
			System.out.print("Enter age of student : ");
			ages[i] = sc.nextInt();
		}
		
		// Iterating array, calling function and printing result
		for(int i = 0; i < 10; i++){
			if(canStudentVote(ages[i])) System.out.println("Student " + (i+1) + " can vote");
			else System.out.println("Student " + (i+1) + " cannot vote");
		}
		
		sc.close();
	}
}