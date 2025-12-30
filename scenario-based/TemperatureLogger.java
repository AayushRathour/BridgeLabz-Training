import java.util.*;

public class TemperatureLogger{
    public static void main(String[] args) {
		// Used Scanner for taking input from the user and also create some variable 
        Scanner sc = new Scanner(System.in);
        int[] temp = new int[7];
		int total = 0;
		int max = 0;
		int idx = 0;
		// used loop for taking input from user and storing it in array
		for(int i = 0; i < temp.length; i++){
			System.out.println("Enter the Temperature for day " + i);
			temp[i] = sc.nextInt();
			total += temp[i];
			// use condition to find the maximum tempareture and day
			if(i == 0 || temp[i] > max){
				max = temp[i];
				idx = i;
			}
		}
		// calculated the average 
		double average = (double) total / 7;
		// printed the output 
        System.out.println("the Max temperature was :" + max + " on: " + idx + " And the average Temperature is :" + average);
    }
}
