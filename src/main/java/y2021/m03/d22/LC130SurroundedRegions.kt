package y2021.m03.d22

class LC130SurroundedRegions {
    // O(n) time, O(n) space
    fun solve(board: Array<CharArray>): Unit {
        if (board.isEmpty() || board.first().isEmpty()) return
        val safe = Array(board.size) { BooleanArray(board[0].size) { false } }

        // only start from edges
        val edges = (board.indices.flatMap { listOf(it to 0, it to board[0].lastIndex) } +
                board[0].indices.flatMap { listOf(0 to it, board.lastIndex to it) })
            .toSet()

        for (pos in edges) {
            travel(pos, board, safe)
        }
        for (rowI in safe.indices) {
            val row = safe[rowI]
            for (colI in row.indices) {
                board[rowI][colI] = if (row[colI]) 'O' else 'X'
            }
        }
    }

    fun travel(
        pos: Pair<Int,Int>,
        board: Array<CharArray>,
        safe: Array<BooleanArray>
    ) {
        if (
            pos.first !in 0..board.lastIndex ||
            pos.second !in 0..board[0].lastIndex ||
            safe[pos.first][pos.second] ||
            board[pos.first][pos.second] == 'X'
        ) {
            return
        }

        safe[pos.first][pos.second] = true
        listOf(
            1 to 0,
            -1 to 0,
            0 to 1,
            0 to -1
        ).map { pos.first + it.first to pos.second + it.second }
            .forEach { travel(it, board, safe) }
    }
}
