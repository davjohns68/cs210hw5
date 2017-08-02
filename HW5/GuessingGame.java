// CS210 Assignment #5 "GuessingGame"
// David Johnson
// This program randomly generates a number from 1 to 100 and asks the user to guess it

import java.util.*;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random rand = new Random();
        
        Boolean done = false;
        int totalGames = 0;
        int totalTries = 0;
        int bestGame = 0;
        
        while (!done) {
            // Here comes the number!
            int number = rand.nextInt(100) + 1;
            totalGames++;
            System.out.println("I'm thinking of a number between 1 and 100...");
            Boolean correct = false;
            int tries = 0;
            // While the user is incorrect, keep asking for guesses
            while (!correct) {
                tries++;
                int guess = getGuess(console);
                correct = compareGuess(number, guess);
            }
            System.out.println("You guessed it in " + tries + " guesses!");
            totalTries += tries;
            if (bestGame == 0 || tries < bestGame) {
                bestGame = tries;
            }
            System.out.print("Play again? ");
            String again = console.next();
            // If the user enters anything beginning with "y," we assume he wants
            // to keep playing
            if (!again.toLowerCase().startsWith("y")) {
                done = true;
            }
        }
        
        // We're done!  Let's print the statistics
        System.out.println();
        System.out.println("Your overall results:");
        System.out.println("Total games = " + totalGames);
        System.out.println("Total guesses = " + totalTries);
        System.out.println("Guesses/game = " + (double) totalTries / totalGames);
        System.out.println("Best game = " + bestGame);
    }
    
    // Compares the guess against the number and prints relative position
    // returns true only if user correct
    public static Boolean compareGuess(int n, int g) {
        // if guess is high...
        if (n < g) {
            System.out.println("It's lower.");
            return false;
            // if the guess is low...
        } else if (n > g) {
            System.out.println("It's higher.");
            return false;
        } else {
            return true;
        }
        
    }
    
    // Function that gets the users guess and returns it
    public static int getGuess(Scanner c) {
        System.out.print("Your guess? ");
        int guess = c.nextInt();
        return guess;
    }
}
