package rockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] choices = {"", "Rock", "Scissors", "Paper"};

        while (true) {
            System.out.println("Choose: 1 - Rock, 2 - Scissors, 3 - Paper, 0 - Quit the game");
            int userChoice = scanner.nextInt();

            if (userChoice == 0) {
                break;
            }

            int computerChoice = new Random().nextInt(choices.length - 1) + 1;

            System.out.println("Your choice: " + choices[userChoice]);
            System.out.println("Computer's choice: " + choices[computerChoice]);

            int result = determineWinner(userChoice, computerChoice);

            switch (result) {
                case 0:
                    System.out.println("It's a tie!");
                    break;
                case 1:
                    System.out.println("You win!");
                    break;
                case -1:
                    System.out.println("You lose!");
                    break;
            }
        }

        System.out.println("Game over.");
    }

    private static int determineWinner(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
            return 0; // It's a tie
        }

        return switch (userChoice) {
            case 1 -> (computerChoice == 2) ? 1 : -1; // Rock
            case 2 -> (computerChoice == 3) ? 1 : -1; // Scissors
            case 3 -> (computerChoice == 1) ? 1 : -1; // Paper
            default -> throw new IllegalArgumentException("Invalid choice");
        };
    }
}
