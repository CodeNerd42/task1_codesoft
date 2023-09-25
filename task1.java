import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalAttempts = 0;
        int bestScore = Integer.MAX_VALUE;
        int roundsPlayed = 0;

        System.out.println("Welcome to the Guess the Number game!");

        while (true) {
            roundsPlayed++;
            int secretNumber = random.nextInt(100) + 1; 
            int attempts = 0;
            int maxAttempts = 10; 

            System.out.println("Round " + roundsPlayed + ": I'm thinking of a number between 1 and 100.");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                totalAttempts++;

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.");
                    if (attempts < bestScore) {
                        bestScore = attempts;
                    }
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + secretNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                break;
            }
        }

        System.out.println("Thanks for playing " + roundsPlayed + " rounds!");
        System.out.println("Your best score was " + bestScore + " attempts in a single round.");
        System.out.println("Your average score across all rounds was " + (double) totalAttempts / roundsPlayed + " attempts.");
    }
}