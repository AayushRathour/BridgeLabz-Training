import java.util.*;

public class NumberCheckUsingArray{
    public static void main(String[] args) {
		// Creating scanner object and taking input
        Scanner sc = new Scanner(System.in);
		
		int number[] = new int[5];
		
		// taking input in array using a loop
		for(int i = 0; i < number.length; i++){
			System.out.print("Enter number : ");
			number[i] = sc.nextInt();
		}
		for (int i =0; i<number.length; i++){
			if (number[i]>0){
				if (number[i]%2 == 0){
					System.out.println("Number is Even");break;
				}
				else{
					System.out.println("Number is odd");break;
				}
			}
			else if (number[i] == 0){
				System.out.println("Number is Zero");break;
			}
			else{
				System.out.println("Number is Negative");break;
			}
		}
		if (number[0] < number[4]){
			System.out.println("Number is Less");
		} 
		else if (number[0] > number[4]){
			System.out.println("Number is Greater");
		}
		else {
			System.out.println("Number is Less");
		}	
	
		

    }
}