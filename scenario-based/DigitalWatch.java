import java.util.*;

public class DigitalWatch{
    public static void main(String[] args) {
		// used loop for printing again and again 
        for(int i = 0; i < 24; i++){
            for(int j = 0; j < 60; j++){
				// breaked whe reach at 13
                if(i == 13 && j == 0){
                    break;
                }
                System.out.println(i + " Hours : " + j + " Minutes");
            }
            if(i == 13){
                break;
            }
        }
    }
}
