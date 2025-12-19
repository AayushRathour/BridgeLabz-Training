import java.util.*;

public class OddOrEvenWithArray{
    public static void main(String[] args) {
		// Creating Scanner Object and initializing array
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter a numbwer");
		int number = sc.nextInt();
		if (number > 0){
			int size = (number/2)+1;
			int[] even = new int[size];
			int[] odd = new int[size];
			int EvenIndex = 0;
			int OddIndex = 0;
			for (int i =1 ; i<number	; i++){
				if (i%2 == 0){
					even[EvenIndex]= i;
					EvenIndex++;
				}
				else{
					odd[OddIndex] = i;
					OddIndex++;
				}
			}
			
			for(int i = 1; i<EvenIndex; i++){
				System.out.println( + even[i]);
			}
			System.out.println();
			for(int i = 1; i<OddIndex; i++){
				System.out.println( + odd[i]);
			}
		}
		else{
			System.out.println("Error");
		}
		
    }
}