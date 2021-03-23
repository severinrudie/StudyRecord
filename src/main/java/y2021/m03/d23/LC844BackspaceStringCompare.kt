package y2021.m03.d23

class LC844BackspaceStringCompare {
    fun backspaceCompare(s: String, t: String): Boolean {
        val finals = listOf(s, t).map { str ->
            str.fold(listOf<Char>()) { acc, c ->
                if (c == '#') {
                    if (acc.size > 0) acc.dropLast(1)
                    else acc
                } else {
                    acc + c
                }
            }
        }

        return finals[0] == finals[1]
    }
}
