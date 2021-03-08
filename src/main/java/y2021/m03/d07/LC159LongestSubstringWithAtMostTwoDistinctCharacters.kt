package y2021.m03.d07

import kotlin.math.max

class LC159LongestSubstringWithAtMostTwoDistinctCharacters {
    fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
        val chars = mutableMapOf<Char, Int>()
        var l = 0
        var r = 0
        var longest = 0

        while (r <= s.lastIndex) {
            if (chars.size > 2) {
                val c = s[l]
                chars[c] = chars[c]!! - 1
                if (chars[c] == 0) chars.remove(c)
                l++
            } else {
                val c = s[r]
                chars[c] = (chars[c] ?: 0) + 1
                r++
                if (chars.size <= 2) longest = max(longest, r - l)
            }
        }

        return longest
    }
}
