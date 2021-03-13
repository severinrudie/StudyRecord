package y2021.m03.d12

class LC642DesignSearchAutocompleteSystem {
    // Done in a rush during a mock interview.  Unfinished, does not pass
    class AutocompleteSystem(val sentences: Array<String>, times: IntArray) {

        val map = sentences.zip(times.toList()).toMap().toMutableMap()
        var sorted = sentences.sorted().toList()

        var stem = ""

        fun input(c: Char): List<String> {
            if (c == '#') {
                sorted = (sorted + stem).sorted()
                map[stem] = (map[stem] ?: 0) + 1
                stem = ""
                return emptyList()
            }
            stem += c

            val matchRange = getRangeFor(stem)
            if (matchRange == null) return emptyList()

            val (left, right) = matchRange
            val matches = if (right == -1) sorted.subList(left, sorted.size).toSet()
            else sorted.subList(left, right + 1).toSet()

            return map.filter { (k,v) -> k in matches }
                .toList()
                .sortedBy { (k,v) -> k }
                .sortedByDescending { (k,v) -> v }
                .take(3)
                .map { it.first }
        }

        fun getRangeFor(
            word: String,
            nthChar: Int = 0,
            from: Int = 0,
            to: Int = sorted.lastIndex
        ): Pair<Int, Int>? {
            if (nthChar > word.lastIndex) return from to to
            val target = word[nthChar]

            fun get(wordI: Int): Char? {
                if (
                    wordI in sorted.indices &&
                    sorted[wordI].lastIndex < nthChar
                ) return null
                if (wordI < 0) return null
                return sorted[wordI][nthChar]
            }

            fun bs(forChar: Char, against: Boolean = false, l: Int = from): Int {
                var l = l
                var r = to
                while (l < r) {
                    val midI = (r - l) / 2 + l
                    val mid = get(midI)

                    if (mid == null) {
                        r = midI - 1
                    } else if (against && mid == target) {
                        l = midI + 1
                    } else if (mid == target) {
                        r = midI - 1
                    } else if (mid < target) {
                        l = midI + 1
                    } else {
                        r = midI - 1
                    }
                }
                return when {
                    forChar == get(l) -> l
                    forChar == get(l + 1) -> l + 1
                    forChar == get(l - 1) -> l - 1
                    else -> -1
                }
            }

            val left = bs(target)
            val right = bs(target, true, left)

            if (left == -1) return null
            val nextRight = if (right == -1) to else right

            return getRangeFor(word, nthChar + 1, left, nextRight)
        }
    }
}