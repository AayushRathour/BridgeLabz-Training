import java.util.*;

public class OnlineQuiz {
    public static void main(String[] args) {
		 // Creating scanner class object and taking input
        Scanner sc = new Scanner(System.in);
		
		// used Array to store the currect answers
        String[] answers = {"C","C","C","D","D"};
        int currect = 0;
		int i =0;
		
		// usesd while loop so that user will answer only 5 Questions
		// Putteen MCQ Questions with option 
        while(i<5){

            System.out.println("1. Which component of Java is responsible for running bytecode?");
            System.out.println("A) JDK");
            System.out.println("B) JRE");
            System.out.println("C) JVM");
            System.out.println("D) Compiler");

            System.out.println("2. Which keyword is used to inherit a class in Java?");
            System.out.println("A) implement");
            System.out.println("B) inherits");
            System.out.println("C) extends");
            System.out.println("D) super");

            System.out.println("3. Which of the following is NOT a primitive data type in Java?");
            System.out.println("A) int");
            System.out.println("B) float");
            System.out.println("C) String");
            System.out.println("D) char");

            System.out.println("4. What is the default value of an instance variable in Java?");
            System.out.println("A) garbage value");
            System.out.println("B) 0");
            System.out.println("C) null");
            System.out.println("D) depends on data type");

            System.out.println("5. Which method is the entry point of a Java program?");
            System.out.println("A) start()");
            System.out.println("B) run()");
            System.out.println("C) init()");
            System.out.println("D) main()");

            System.out.println("Please Select Question number");
            int Question = sc.nextInt();

            System.out.println("Please Select Correct Answer 'A', 'B', 'C', 'D'");
            String ans = sc.next();
			i++;
			// used Switch case to check currect anwer
            switch(Question){
                case 1:
                    if(ans.equalsIgnoreCase(answers[0])){
                        currect++;
                        System.out.println("Correct Answer");
                    } else {
                        System.out.println("Wrong Answer");
                    }
                    break;

                case 2:
                    if(ans.equalsIgnoreCase(answers[1])){
                        currect++;
                        System.out.println("Correct Answer");
                    } else {
                        System.out.println("Wrong Answer");
                    }
                    break;

                case 3:
                    if(ans.equalsIgnoreCase(answers[2])){
                        currect++;
                        System.out.println("Correct Answer");
                    } else {
                        System.out.println("Wrong Answer");
                    }
                    break;

                case 4:
                    if(ans.equalsIgnoreCase(answers[3])){
                        currect++;
                        System.out.println("Correct Answer");
                    } else {
                        System.out.println("Wrong Answer");
                    }
                    break;

                case 5:
                    if(ans.equalsIgnoreCase(answers[4])){
                        currect++;
                        System.out.println("Correct Answer");
                    } else {
                        System.out.println("Wrong Answer");
                    }
                    break;

                default:
                    System.out.println("Invalid Input");
            }

            System.out.println("you answered : " + currect + " Currect Answer");
            
        }
    }
}
