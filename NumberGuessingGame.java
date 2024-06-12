package com.gamedemo;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            playGame(scanner);

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thanks for playing the Number Guessing Game!");
        scanner.close();
    }

    private static void playGame(Scanner scanner) {
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1; // Random number between 1 and 100
        int guess;
        int attemptCount = 0;
        int maxAttempts = 5;
        boolean hasGuessedCorrectly = false;

        System.out.println("I have chosen a number between 1 and 100. Try to guess it!");
        System.out.println("If you want to know the number, enter -1.");
        System.out.println("You have " + maxAttempts + " attempts to guess the number.");

        while (!hasGuessedCorrectly && attemptCount < maxAttempts) {
            System.out.print("Enter your guess: ");

            // Input validation
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
                continue;
            }

            guess = scanner.nextInt();
            attemptCount++;

            if (guess == -1) {
                System.out.println("The random number is: " + targetNumber);
                continue; // Continue to the next iteration of the loop
            }

            switch (Integer.compare(guess, targetNumber)) {
                case -1:
                    System.out.println("Your guess is too low.");
                    break;
                case 1:
                    System.out.println("Your guess is too high.");
                    break;
                case 0:
                    System.out.println("Congratulations! You've guessed the correct number in " + attemptCount + " attempts.");
                    hasGuessedCorrectly = true;
                    break;
                default:
                    // This default case is technically unnecessary as Integer.compare will always return -1, 0, or 1.
                    break;
            }

            if (!hasGuessedCorrectly && attemptCount == maxAttempts) {
                System.out.println("You've used all your attempts! The correct number was " + targetNumber + ".");
            }
        }
    }
}
