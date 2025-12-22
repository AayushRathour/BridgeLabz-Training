import java.util.*;

class RockPaperScissorsGame{
    // method for random choice of three
    public static String getRandom() {
        int choice = (int)(Math.random() * 3);
        if (choice == 0) return "Rock";
        else if (choice == 1) return "Paper";
        return "Scissors";
    }

    // returning winner
    public static String getWinner(String user, String computer) {
        if (user.equals(computer))
            return "Draw";

        if ((user.equals("Rock") && computer.equals("Scissors")) || (user.equals("Paper") && computer.equals("Rock")) || (user.equals("Scissors") && computer.equals("Paper")))
            return "User";
        return "Computer";
    }

    // calculte the average and percentage wins
    public static String[][] calculate(int userWins, int computerWins, int games) {
        String[][] result = new String[2][2];
        double userPercent = (userWins * 100.0) / games;
        double compPercent = (computerWins * 100.0) / games;

        result[0] = new String[]{"" + userWins, "" + userPercent};
        result[1] = new String[]{"" + computerWins, "" + compPercent};

        return result;
    }

    // Printing the results
    public static void display(String[][] gameResults, String[][] results) {
        for (int i = 0; i < gameResults.length; i++) {
            System.out.println((i + 1) + " " + gameResults[i][0] + " " + gameResults[i][1] + " " + gameResults[i][2]);
        }
        for (String[] s : results) {
            System.out.println(s[0] + " " + s[1]);
        }
    }

    public static void main(String[] args) {
		// Creating scanner object
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int n = sc.nextInt();
        String[][] gameResults = new String[n][3];
        int userWins = 0;
		int computerWins = 0;
		
		// using for loop and call fucntions
        for (int i = 0; i < n; i++) {
            System.out.print("Enter your choice: ");
            String user = sc.next();
            String computer = getRandom();
            String winner = getWinner(user, computer);
			
            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) computerWins++;

            gameResults[i][0] = user;
            gameResults[i][1] = computer;
            gameResults[i][2] = winner;
        }

        String[][] stats = calculate(userWins, computerWins, n);
        display(gameResults, stats);
    }
}