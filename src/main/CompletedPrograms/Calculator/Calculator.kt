package Calculator

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