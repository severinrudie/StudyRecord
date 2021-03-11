package y2021.m03.d09

class LC329LongestIncreasingPathInAMatrix {
    data class Pos(val row: Int, val col: Int)

    // O(n) time, O(n) space
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val parents = mutableMapOf<Pos, Int>()
        val children = mutableMapOf<Pos, List<Pos>>()
        val values = mutableMapOf<Pos, Int>()

        for (rowI in matrix.indices) {
            val row = matrix[rowI]
            for (colI in row.indices) {
                val value = matrix[rowI][colI]

                values[Pos(rowI, colI)] = value
            }
        }

        for ((pos, value) in values) {
            if (parents[pos] == null) parents[pos] = 0
            if (children[pos] == null) children[pos] = emptyList()
            val neighbors = pos.possibleNeighbors().filter { it in values.keys }

            val bigger = neighbors.filter { values[it]!! > value }

            for (big in bigger) {
                children[pos] = (children[pos] ?: emptyList()) + big
                parents[big] = (parents[big] ?: 0) + 1
            }
        }

        val travelled = setOf<Pos>()
        val sources = parents.filter { (k,v) -> v == 0 }
            .map { (k,v) -> k }
            .toMutableList()

        var longest = 0
        while (sources.isNotEmpty()) {
            for (i in 1..sources.size) {
                val next = sources.removeAt(0)
                val toDec = children[next]!!

                for (child in toDec) {
                    parents[child] = parents[child]!! - 1
                    if (parents[child] == 0) sources += child
                }
            }
            longest++
        }
        return longest
    }

    fun Pos.possibleNeighbors() = listOf(
        0 to 1,
        1 to 0,
        0 to -1,
        -1 to 0
    ).map { Pos(this.row + it.first, this.col + it.second) }
}