import java.util.*; 

public class CharactersInString{
	// created method to return an array of characters of given string
	public static char[] getArray(String s){
		int n = s.length();
		char[] result = new char[n];
		
		for(int i = 0; i < n; i++) result[i] = s.charAt(i);
		return result;
	}
	
	// method to compare characters of array 
	public static boolean compareArray(char[] arr1, char[] arr2){
		int n = arr1.length;
		
		for(int i = 0; i < n; i++){
			if(arr1[i] != arr2[i]) return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		// creating scanner object and taking input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter strings : ");
		String s = sc.next();
		
		// calling method and printing result
		char[] arr1 = getArray(s);
		char[] arr2 = s.toCharArray();
		
		if(compareArray(arr1, arr2)) System.out.println("Output is same" + ", the array is " + Arrays.toString(arr1));
		else System.out.println("Output is diffrent");
		
		sc.close();
	}
}