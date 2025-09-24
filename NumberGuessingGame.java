import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int MIN = 1;
        final int MAX = 100;
        final int MAX_ATTEMPTS = 7;

        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between " + MIN + " and " + MAX + ".");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts per round.\n");

        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(MAX - MIN + 1) + MIN;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            roundsPlayed++;

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess (" + attemptsLeft + " attempts left): ");
                int guess;

                // Validate input
                if (!scanner.hasNextInt()) {
                    System.out.println("⚠️ Invalid input. Please enter an integer.");
                    scanner.next(); // clear invalid input
                    continue;
                }

                guess = scanner.nextInt();

                if (guess < MIN || guess > MAX) {
                    System.out.println("⚠️ Please guess a number between " + MIN + " and " + MAX + ".");
                    continue;
                }

                if (guess == targetNumber) {
                    System.out.println("🎉 Congratulations! You guessed the correct number!");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("🔼 Too low!");
                } else {
                    System.out.println("🔽 Too high!");
                }

                attemptsLeft--;
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all your attempts! The correct number was: " + targetNumber);
            }

            // Ask to play again
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
            System.out.println();
        }

        // Final score display
        System.out.println("🏁 Game Over!");
        System.out.println("Rounds Played: " + roundsPlayed);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}
