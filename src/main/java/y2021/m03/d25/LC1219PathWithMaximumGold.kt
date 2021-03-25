package y2021.m03.d25

class LC1219PathWithMaximumGold {
    fun getMaximumGold(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid.first().isEmpty()) return 0

        var best = 0
        for (r in grid.indices) {
            for (c in grid.first().indices) {
                val next = getMaximumGold(grid, setOf(), r, c)
                if (next != null && next > best) best = next
            }
        }

        return best
    }

    fun getMaximumGold(
        grid: Array<IntArray>,
        visited: Set<Pair<Int,Int>>,
        row: Int,
        col: Int
    ): Int? {
        if (
            row to col in visited ||
            row !in grid.indices ||
            col !in grid.first().indices ||
            grid[row][col] == 0
        ) return null

        val neighbors = listOf(
            0 to 1,
            0 to -1,
            1 to 0,
            -1 to 0
        ).map { (row + it.first) to (col + it.second) }

        val newVisited = visited + (row to col)
        val paths = neighbors.mapNotNull { getMaximumGold(grid, newVisited, it.first, it.second) }
        val bestPath = paths.max() ?: 0

        return bestPath + grid[row][col]
    }
}
