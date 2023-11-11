# Kotlin Exercises and Solutions 🚀

Welcome to the "Kotlin Exercises and Solutions" repository! This collection of Kotlin exercises is crafted for completing assignments and improving programming skills.

Feel free to explore and contribute! 🌟

## Progress 📊

### Completed Programs:
1. **Calculator**
   - **Description:** The Calculator program is a simple console-based application that performs basic arithmetic operations. It takes user input for two numbers and an operation choice (addition, subtraction, multiplication, or division) and displays the result. The program is designed to handle incorrect inputs gracefully and prevent division by zero.
   - **Code:**
     ```kotlin
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
