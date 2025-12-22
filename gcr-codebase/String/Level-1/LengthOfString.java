import java.util.*;

public class LengthOfString{
	// created method to find length of string
	public static int getLength(String str){
		int index = 0;
		try{
			while(true){
				char ch = str.charAt(index);
				index++;
			}
		}
		catch(Exception e){
			return index;
		}
	}
	public static void main(String[] args){
		// creating scanner object and taking input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string : ");
		String str = sc.next();
		
		// calling method and printing result
		System.out.println("Length using user defined method : " + getLength(str) +  " and Length using inbuilt method : " + str.length());
		
		sc.close();
	}
}