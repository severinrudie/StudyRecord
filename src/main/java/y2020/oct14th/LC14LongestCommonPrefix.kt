package y2020.oct14th

// Easy, 35%
// O(n * l)
object LC14LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        for (i in strs.first().indices) {
            val c = strs.first()[i]
            if (strs.any { it.lastIndex < i || it[i] != c }) {
                return strs.first().substring(0, i)
            }
        }
        return strs.first()
    }
}
