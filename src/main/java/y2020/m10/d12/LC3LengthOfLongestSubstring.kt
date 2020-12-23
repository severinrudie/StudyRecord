package y2020.m10.d12

import kotlin.math.max

object LC3LengthOfLongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        var maxLength = 0
        var windowStart = 0
        var windowEnd = 0

        val chars = mutableMapOf<Char, Int>()

        while(
                windowStart <= s.lastIndex &&
                windowEnd <= s.lastIndex
        ) {
            val endChar = s[windowEnd]
            chars.putIfAbsent(endChar, 0)
            val startChar = s[windowStart]

            if (chars.getOrDefault(endChar, 0) > 0) {
                chars[startChar] = chars.getOrDefault(startChar, 0) - 1
                windowStart++
            } else {
                chars[endChar] = chars.getOrDefault(endChar, 0) + 1
                windowEnd++
            }
            maxLength = max(maxLength, chars.filter { (k, v) -> v != 0  }.size)
        }
        return maxLength
    }
}