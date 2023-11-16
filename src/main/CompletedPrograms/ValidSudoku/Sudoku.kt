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
