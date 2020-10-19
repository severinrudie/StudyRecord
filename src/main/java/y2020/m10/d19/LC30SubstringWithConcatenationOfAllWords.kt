package y2020.m10.d19

// Hard, 25%
// O(nk) time, O(n) space
object LC30SubstringWithConcatenationOfAllWords {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        if (words.isEmpty()) return emptyList()

        val wordLength = words[0].length
        val totalLength = wordLength * words.size
        if (s.length < totalLength) return emptyList()
        val wordMap = words.groupingBy { it }.eachCount()

        var windowStart = 0
        var windowEnd = totalLength - 1

        val results = mutableListOf<Int>()

        for (i in 0..s.lastIndex - windowEnd) {
            val windowMap = s.substring(windowStart, windowEnd + 1)
                    .windowed(size = wordLength, step = wordLength)
                    .groupingBy { it }
                    .eachCount()
            if (windowMap == wordMap) {
                results += i
            }

            windowStart++
            windowEnd++
        }

        return results
    }
}