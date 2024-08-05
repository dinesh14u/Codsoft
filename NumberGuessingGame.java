import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        char playAgain = 'y';

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain == 'y' || playAgain == 'Y') {
            int number = random.nextInt(100) + 1; // Generate random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 10; // You can adjust this for difficulty

            System.out.println("\nI have generated a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it correctly.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                while (!scanner.hasNextInt()) { // Ensure valid integer input
                    System.out.print("Please enter a valid number: ");
                    scanner.next(); // Consume invalid input
                }
                int guess = scanner.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("Congratulations! You guessed the correct number " + number + " in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (guess < number) {
                    System.out.println("Try again! Your guess is too low.");
                } else {
                    System.out.println("Try again! Your guess is too high.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + number + ".");
            }

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next().charAt(0);
        }

        System.out.println("Thank you for playing! Your score is " + score + ".");
        scanner.close();
    }
}
