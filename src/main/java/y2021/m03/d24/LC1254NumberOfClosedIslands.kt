package y2021.m03.d24

class LC1254NumberOfClosedIslands {
    // O(n) time, O(n) space
    fun closedIsland(grid: Array<IntArray>): Int {
        // when encountering an island, fully explore it
        // add to visited
        // return:
        // if any island pieces touch edge, false
        // else true
        // return true count

        if (grid.isEmpty() || grid.first().isEmpty()) return 0

        val edges = (grid.indices.flatMap { row ->
            listOf(row to 0, row to grid.first().lastIndex)
        } +
                grid.first().indices.flatMap { col ->
                    listOf(0 to col, grid.lastIndex to col)
                }).toSet()

        var goodCount = 0
        val visited = mutableSetOf<Pair<Int,Int>>()
        for (row in grid.indices) {
            for (col in grid.first().indices) {
                if (isClosed(grid, row, col, visited, edges) == true) goodCount++
            }
        }
        return goodCount
    }

    fun isClosed(
        grid: Array<IntArray>,
        row: Int,
        col: Int,
        visited: MutableSet<Pair<Int,Int>>,
        edges: Set<Pair<Int,Int>>
    ): Boolean? {
        if (
            row to col in visited ||
            row !in grid.indices ||
            col !in grid.first().indices ||
            grid[row][col] == 1
        ) return null

        visited += (row to col)

        val neighbors = listOf(
            1 to 0,
            -1 to 0,
            0 to 1,
            0 to -1
        ).map { (row + it.first) to (col + it.second) }

        val rec = neighbors.mapNotNull { isClosed(grid, it.first, it.second, visited, edges) }

        val isValid = (row to col) !in edges

        return isValid && rec.all { it == true }
    }
}