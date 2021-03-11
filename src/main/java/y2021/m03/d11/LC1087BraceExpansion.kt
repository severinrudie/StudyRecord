package y2021.m03.d11

class LC1087BraceExpansion {
    fun expand(s: String): Array<String> {
        if (s.isEmpty()) return emptyArray()
        val buckets = Array(s.length) { mutableListOf<Char>() }

        var inBrackets = false
        var i = 0
        for (c in s) {
            if (c == '{') {
                inBrackets = true
            } else if (c == '}') {
                inBrackets = false
                i++
            } else if (c == ',') {
                // noop
            } else if (!inBrackets) {
                buckets[i].add(c)
                i++
            } else {
                buckets[i].add(c)
            }
        }

        buckets.forEach { it.sort() }

        var stems = buckets.first().map { it.toString() }

        for (i in 1 until i) {
            val nextBucket = buckets[i]
            stems = stems.flatMap { stem ->
                nextBucket.map { stem + it }
            }
        }

        return stems.toTypedArray()
    }
}