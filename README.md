# Kotlin Exercises and Solutions 🚀
[![Maintainability](https://api.codeclimate.com/v1/badges/83beaf52f0ed1b5352f9/maintainability)](https://codeclimate.com/github/ynb4gang/kotlin-exercises-and-solutions/maintainability)

Welcome to the "Kotlin Exercises and Solutions" repository! This collection of Kotlin exercises is crafted for completing assignments and improving programming skills.

Feel free to explore and contribute! 🌟

## Progress 📊

### Completed Programs:
1. **Calculator**
   - **Description:** The Calculator program is a simple console-based application that performs basic arithmetic operations. It takes user input for two numbers and an operation choice (addition, subtraction, multiplication, or division) and displays the result. The program is designed to handle incorrect inputs gracefully and prevent division by zero.
   - **Code:**
     ```kotlin
     // Calculator Code
     import java.util.*

     fun main() {
         // Create a Scanner for user input
         val scanner = Scanner(System.`in`)

         try {
             // Input the first number
             println("Enter the first number:")
             val number1 = scanner.nextDouble()

             // Input the second number
             println("Enter the second number:")
             val number2 = scanner.nextDouble()

             // Display operation choices
             println("Choose an operation:")
             println("1. Addition")
             println("2. Subtraction")
             println("3. Multiplication")
             println("4. Division")

             // Input the operation choice
             val choice = scanner.nextInt()

             // Perform the chosen operation and display the result
             val result = performOperation(number1, number2, choice)
             println("Result of the operation: $result")

         } catch (e: InputMismatchException) {
             // Handle incorrect input
             println("Incorrect input. Please enter valid numbers and operation choice.")
             scanner.next() // Consume the invalid input
         }
     }

     fun performOperation(number1: Double, number2: Double, choice: Int): Any {
         return when (choice) {
             1 -> number1 + number2
             2 -> number1 - number2
             3 -> number1 * number2
             4 -> if (number2 != 0.0) number1 / number2 else "Division by 0 is not possible"
             else -> "Invalid operation choice"
         }
     }
     ```
   - **How to Run:** Copy the code into a Kotlin environment and execute the `main` function. Follow the on-screen instructions to perform calculations.

2. **Valid Sudoku**
   - **Description:** The Valid Sudoku program checks the validity of a given Sudoku board. It ensures that the board satisfies the rules of Sudoku, i.e., no repeated digits in each row, column, and 3x3 subgrid.
   - **Code:**
     ```kotlin
     // Valid Sudoku Code
     class Solution {
         fun isValidSudoku(board: Array<CharArray>): Boolean {
             val seen = HashSet<String>()
             for (row in 0 until 9) {
                 for (col in 0 until 9) {
                     val number = board[row][col]
                     if (number != '.') {
                         val i = row / 3
                         val j = col / 3
                         val rowCheck = !seen.add("$number in row $row")
                         val colCheck = !seen.add("$number in col $col")
                         val blockCheck = !seen.add("$number in block $i-$j")
                         if (rowCheck || colCheck || blockCheck) {
                             return false
                         }
                     }
                 }
             }
             return true
         }
     }

     fun main() {
         val sudokuBoard = Array(9) { CharArray(9) }

         println("Enter values for the Sudoku, using digits from 1 to 9 and a dot (.) for empty cells:")

         for (i in 0 until 9) {
             print("Row ${i + 1}: ")
             val inputRow = readLine()
             if (inputRow != null && inputRow.length == 9) {
                 for (j in 0 until 9) {
                     sudokuBoard[i][j] = inputRow[j]
                 }
             } else {
                 println("Incorrect input. Please enter 9 characters.")
                 return
             }
         }

         val solution = Solution()
         val result = solution.isValidSudoku(sudokuBoard)

         if (result) {
             println("This Sudoku is valid.")
         } else {
             println("This Sudoku is not valid.")
         }
     }
     ```
   - **How to Run:** Copy the code into a Kotlin environment and execute the `main` function. Follow the on-screen instructions to check the validity of a Sudoku board.
3. ## Koko Eating Bananas

### Description:
The "Koko Eating Bananas" program solves a classic algorithmic problem. Koko loves eating bananas, and there are N piles of bananas, where the i-th pile contains `piles[i]` bananas. Koko can eat bananas from the piles, and each day she chooses a pile, eats some bananas, and removes a portion of the pile. The goal is to determine the minimum integer `K` such that Koko can eat all the bananas within `H` hours. If Koko eats `K` bananas from a pile on a given day, then on the next day, she must eat at least the same number of bananas from another pile or the same pile.

### Implementation:

```kotlin
package KokoEatingBananas

class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var max = 0
        for (pile in piles) {
            max = maxOf(max, pile)
        }
        var right = max

        while (left < right) {
            val mid = left + (right - left) / 2

            if (canEat(piles, h, mid)) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return left
    }

    fun canEat(piles: IntArray, h: Int, k: Int): Boolean {
        var hours = 0

        for (pile in piles) {
            hours += (pile + k - 1) / k
        }

        return hours <= h
    }
}

fun main() {
    val solution = Solution()

    val piles = intArrayOf(3, 6, 7, 11)
    val h = 8

    val result = solution.minEatingSpeed(piles, h)

    println("Koko can eat $result bananas in $h hours.")
}
```
- **How to Run:** Copy the code into a Kotlin environment and execute the main function. Follow the on-screen instructions to calculate the minimum eating speed K for Koko to consume all bananas within H hours.

## How to Contribute 🤝

1. Fork the repository.
2. Create a new branch for your changes.
3. Make your contributions.
4. Submit a pull request.

## Connect with Me 🌐

Feel free to reach out if you have any questions, suggestions, or just want to chat! 😊

- [Discord](https://discordapp.com/users/buccellati_scumbag/)
- [LeetCode](https://leetcode.com/young_carti)
- [Telegram](t.me/LuvDyrachyo)
- [VK](https://vk.com/daxxxak)

Happy coding! 😄
