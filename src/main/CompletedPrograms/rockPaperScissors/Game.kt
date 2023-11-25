// Rock, Paper, Scissors Game Code
package rockPaperScissors

import java.util.*

object Game {
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        val choices = arrayOf("", "Rock", "Scissors", "Paper")
        while (true) {
            println("Choose: 1 - Rock, 2 - Scissors, 3 - Paper, 0 - Quit the game")
            val userChoice = scanner.nextInt()
            if (userChoice == 0) {
                break
            }
            val computerChoice = Random().nextInt(choices.size - 1) + 1
            println("Your choice: " + choices[userChoice])
            println("Computer's choice: " + choices[computerChoice])
            val result = determineWinner(userChoice, computerChoice)
            when (result) {
                0 -> println("It's a tie!")
                1 -> println("You win!")
                -1 -> println("You lose!")
            }
        }
        println("Game over.")
    }

    private fun determineWinner(userChoice: Int, computerChoice: Int): Int {
        return if (userChoice == computerChoice) {
            0 // It's a tie
        } else when (userChoice) {
            1 -> if (computerChoice == 2) 1 else -1
            2 -> if (computerChoice == 3) 1 else -1
            3 -> if (computerChoice == 1) 1 else -1
            else -> throw IllegalArgumentException("Invalid choice")
        }
    }
}
