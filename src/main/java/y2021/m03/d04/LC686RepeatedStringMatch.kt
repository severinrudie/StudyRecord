package y2021.m03.d04

import kotlin.math.max

class LC686RepeatedStringMatch {
    // O(b * b / a), O(b) space
    fun repeatedStringMatch(a: String, b: String): Int {
        var repeated = a.repeat(max(1, b.length / a.length))

        while (repeated.length < b.length + (2 * a.length)) {
            if (repeated.contains(b)) break
            repeated += a
        }

        if (repeated.contains(b)) return repeated.length / a.length
        else return -1
    }
}