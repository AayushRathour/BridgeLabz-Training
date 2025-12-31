import java.util.*;

public class  FestivalLuckyDraw{
    public static void main(String[] args) {
		// Creating scanner class object and taking input
        Scanner sc = new Scanner(System.in);
		System.out.println("Wellcome to Luck Draw");
		//used the while loop to aske user to guss again and again if loosing
        while(true){
			System.out.println("Guess the Number : ");
			int num = sc.nextInt();
			// used conditions and check if user wins
			// if win continues the game else exit the game 
			if(num % 3 ==0 || num % 5 ==0){
				System.out.println("Congratulation you won a Gift");
				continue;
				
				
			}
			else{
				System.out.println("Hard luck , you Gussed wrong");
				System.out.println("Guss the number again if want ");
				break;
				
			}
		}
		
    }
}
