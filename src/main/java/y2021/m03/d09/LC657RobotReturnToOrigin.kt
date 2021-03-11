package y2021.m03.d09

class LC657RobotReturnToOrigin {
    // O(n) time, O(1) space
    fun judgeCircle(moves: String): Boolean {
        var hozOffset = 0
        var vertOffset = 0

        for (c in moves) {
            when (c) {
                'U' -> vertOffset++
                'D' -> vertOffset--
                'R' -> hozOffset++
                'L' -> hozOffset--
                else -> throw RuntimeException()
            }
        }

        return hozOffset == 0 && vertOffset == 0
    }
}
