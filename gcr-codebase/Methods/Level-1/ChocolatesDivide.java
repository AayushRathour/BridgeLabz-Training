import java.util.*;

public class ChocolatesDivide{
	// return an array with chocolates per student and remaning chocolates
	public static int[] findChocolates(int chocolates, int childs){
		int[] result = new int[2];
		result[0] = chocolates / childs;
		result[1] = chocolates % childs;
		return result;
	}
	
	public static void main(String[] args){
		// creating scanner object and taking input 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter chocolates and childs : ");
		int chocolates = sc.nextInt();
		int childs = sc.nextInt();
		
		// calling function and printing result
		int[] result = findChocolates(chocolates, childs);
		System.out.println("The chocolates per child are : " + result[0] + " and remaning chocolates are : " + result[1]);
		sc.close();
	}
}