package y2021.m03.d08

import kotlin.math.max

class LC695MaxAreaOfIsland {
    data class Pos(val row: Int, val col: Int) {
        fun neighbors(lastRowIndex: Int, lastColIndex: Int, grid: Array<IntArray>): List<Pos> {
            return listOf(
                Pos(row + 1, col),
                Pos(row - 1, col),
                Pos(row, col + 1),
                Pos(row, col - 1)
            ).filter {
                it.row in 0..lastRowIndex &&
                        it.col in 0..lastColIndex
            }.filter { grid[it.row][it.col] == 1 }
        }
    }

    val visited = mutableSetOf<Pos>()

    // O(n) time, O(n) space
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0
        visited.clear()

        var biggest = 0
        for (rowI in grid.indices) {
            val row = grid[rowI]
            for (colI in row.indices) {
                if (row[colI] == 1) {
                    biggest = max(biggest, countIsland(Pos(rowI, colI), grid))
                }
            }
        }

        return biggest
    }

    fun countIsland(pos: Pos, grid: Array<IntArray>): Int {
        if (pos in visited) return 0
        visited += pos

        val lastRowIndex = grid.lastIndex
        val lastColIndex = grid[0].lastIndex

        return 1 + pos.neighbors(lastRowIndex, lastColIndex, grid).map { countIsland(it, grid) }.sum()
    }
}