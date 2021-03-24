package y2021.m03.d24

class Pramp_ShortestCellPath {
    data class Pos(val row: Int, val col: Int)

    fun shortestCellPath(
        grid: Array<IntArray>,
        curr: Pos,
        end: Pos,
    ): Int {
        val result = shortestCellPath(grid, curr, end, setOf(), mutableMapOf())
        return result ?: -1
    }

    fun shortestCellPath(
        grid: Array<IntArray>,
        curr: Pos,
        end: Pos,
        visited: Set<Pos>,
        mem: MutableMap<Pos, Int>
    ): Int? {

        if (mem.contains(curr)) return mem[curr]!!
        if (grid.isEmpty() || grid.first().isEmpty()) return 0
        if (
            curr in visited ||
            curr.row !in grid.indices ||
            curr.col !in grid.first().indices ||
            grid[curr.row][curr.col] == 0
        ) return null

        if (curr == end) return 0

        val neighbors = listOf(
            0 to 1,
            0 to -1,
            1 to 0,
            -1 to 0
        ).map { Pos(curr.row + it.first, curr.col + it.second) }

        val newVisited = visited + curr
        val pathDistances = neighbors.mapNotNull { newPos ->
            shortestCellPath(grid, newPos, end, newVisited, mem)
        }

        if (pathDistances.isEmpty()) return null

        val result = pathDistances.min()!! + 1
        mem[curr] = result
        return result
    }
}