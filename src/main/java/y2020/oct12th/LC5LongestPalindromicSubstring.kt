package y2020.oct12th

object LC5LongestPalindromicSubstring {
    // Time : O(n ^ 2)
    // Space: O(1)
    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""
        var best = s.first().toString()

        s.forEachIndexed { i, c ->
            best = listOf(
                    best,
                    maxFrom(s, i, i),
                    maxFrom(s, i, i + 1)
            ).maxBy { it.length }!!
        }

        return best
    }

    fun maxFrom(s: String, start: Int, end: Int): String {
        if (start < 0 || end > s.lastIndex) return ""
        if (s[start] != s[end]) return ""
        var start = start
        var end = end
        while (start > 0 && end < s.lastIndex && s[start - 1] == s[end + 1]) {
            start--
            end++
        }
        return s.substring(start, end + 1)
    }
}
