package y2021.m03.d24

class LC1138AlphabetBoardPath {
    val zPos = getPos('z')

    // O(n) time, O(n) space [max moves between chars is bounded]
    fun alphabetBoardPath(target: String): String {
        val result = StringBuilder()

        var pos = 0 to 0
        for (c in target) {
            val tPos = getPos(c)
            while (pos != tPos) {
                when {
                    pos == zPos -> {
                        result.append('U')
                        pos = (pos.first - 1) to pos.second
                    }
                    tPos == zPos && pos.second != 0 -> {
                        result.append('L')
                        pos = pos.first to (pos.second -1)
                    }
                    tPos.first < pos.first -> {
                        result.append('U')
                        pos = (pos.first - 1) to pos.second
                    }
                    tPos.first > pos.first -> {
                        result.append('D')
                        pos = (pos.first + 1) to pos.second
                    }
                    tPos.second < pos.second -> {
                        result.append('L')
                        pos = pos.first to (pos.second - 1)
                    }
                    tPos.second > pos.second -> {
                        result.append('R')
                        pos = pos.first to (pos.second + 1)
                    }
                }
            }
            result.append('!')
        }
        return result.toString()
    }

    fun getPos(c: Char): Pair<Int, Int> {
        val row = when (c) {
            'a','b','c','d','e' -> 0
            'f','g','h','i','j' -> 1
            'k','l','m','n','o' -> 2
            'p','q','r','s','t' -> 3
            'u','v','w','x','y' -> 4
            'z' -> 5
            else -> throw RuntimeException()
        }

        val col = when (c) {
            'a','f','k','p','u','z' -> 0
            'b','g','l','q','v' -> 1
            'c','h','m','r','w' -> 2
            'd','i','n','s','x' -> 3
            'e','j','o','t','y' -> 4
            else -> throw RuntimeException()
        }

        return row to col
    }
}
