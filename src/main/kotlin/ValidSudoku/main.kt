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

    println("Введите значения для судоку, используя цифры от 1 до 9 и точку для пустых ячеек:")

    for (i in 0 until 9) {
        print("Строка ${i + 1}: ")
        val inputRow = readLine()
        if (inputRow != null && inputRow.length == 9) {
            for (j in 0 until 9) {
                sudokuBoard[i][j] = inputRow[j]
            }
        } else {
            println("Некорректный ввод. Пожалуйста, введите 9 символов.")
            return
        }
    }

    val solution = Solution()
    val result = solution.isValidSudoku(sudokuBoard)

    if (result) {
        println("Данное судоку является корректным.")
    } else {
        println("Данное судоку не является корректным.")
    }
}
