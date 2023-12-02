package RottingOranges

class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return -1
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 2) rotAdjacent(grid, i, j, 2)
            }
        }
        var minutes = 2
        for (row in grid) {
            for (cell in row) {
                if (cell == 1) return -1
                minutes = maxOf(minutes, cell)
            }
        }

        return minutes - 2
    }

    private fun rotAdjacent(grid: Array<IntArray>, i: Int, j: Int, minutes: Int) {
        val rows = grid.size
        val cols = grid[0].size

        if (i !in 0 until rows || j !in 0 until cols || grid[i][j] == 0 || (1 < grid[i][j] && grid[i][j] < minutes)) {
            return
        } else {
            grid[i][j] = minutes
            rotAdjacent(grid, i - 1, j, minutes + 1)
            rotAdjacent(grid, i + 1, j, minutes + 1)
            rotAdjacent(grid, i, j - 1, minutes + 1)
            rotAdjacent(grid, i, j + 1, minutes + 1)
        }
    }
}

fun main() {
    val solution = Solution()
    val grid = arrayOf(
        intArrayOf(2, 1, 1),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 1, 1)
    )

    val result = solution.orangesRotting(grid)

    if (result != -1) {
        println("It takes $result minutes for all oranges to rot.")
    } else {
        println("It's impossible for all oranges to rot.")
    }
}
