package y2021.m03.d05

class LC361BombEnemy {
    data class Count(var up: Int?, var down: Int?, var left: Int?, var right: Int?)

    // Only faster than 11% of submissions.  Must be a better approach
    // O(n) time, O(n) space
    fun maxKilledEnemies(grid: Array<CharArray>): Int {
        val counts = Array(grid.size) { Array<Count>(grid[0].size) { Count(null, null, null, null) } }

        val dummyVal = Count(0, 0, 0, 0)
        val dummyRow = Array(grid[0].size) { dummyVal }

        for (rowI in grid.indices) {
            val row = grid[rowI]
            for (colI in row.indices) {
                val c = row[colI]

                if (c == 'W') {
                    with(counts[rowI][colI]) {
                        up = 0
                        down = 0
                        left = 0
                        right = 0
                    }
                    continue
                }

                val higher = counts.getOrElse(rowI - 1) { dummyRow }[colI].up
                val lefter = counts[rowI].getOrElse(colI - 1) { dummyVal }.left

                val base = if (c == 'E') 1 else 0

                with(counts[rowI][colI]) {
                    up = base + higher!!
                    left = base + lefter!!
                }
            }
        }

        for (rowI in grid.lastIndex downTo 0) {
            val row = grid[rowI]
            for (colI in row.lastIndex downTo 0) {
                val c = row[colI]

                if (c == 'W') continue

                val lower = counts.getOrElse(rowI + 1) { dummyRow }[colI].down
                val righter = counts[rowI].getOrElse(colI + 1) { dummyVal }.right

                val base = if (c == 'E') 1 else 0

                with(counts[rowI][colI]) {
                    down = base + lower!!
                    right = base + righter!!
                }
            }
        }

        var most = 0
        for (rowI in grid.indices) {
            val row = grid[rowI]
            for (colI in row.indices) {
                val c = row[colI]
                if (c == '0') {
                    val count = counts[rowI][colI]
                    val total = count.up!! + count.down!! + count.left!! + count.right!!
                    if (total > most) {
                        most = total
                    }
                }
            }
        }

        return most
    }
}