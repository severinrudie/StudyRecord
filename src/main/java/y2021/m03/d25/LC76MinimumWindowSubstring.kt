package y2021.m03.d25

class LC76MinimumWindowSubstring {
    // O(n) time, O(k) space
    fun minWindow(str: String, chars: String): String {
        if (chars.length > str.length) return ""
        val arrCount = chars.groupingBy { it }.eachCount()

        var l = 0
        var r = 0
        val strCount = mutableMapOf<Char, Int>()

        var best = ""
        var currWindow = ""

        var charMatches = 0

        while(l <= str.lastIndex) {
            val containsAll = charMatches == chars.length

            if (containsAll && (best.isEmpty() || currWindow.length < best.length)) {
                best = currWindow;
            }

            if (containsAll) {
                // shrink window
                currWindow = currWindow.drop(1)
                val c = str[l] // x
                if ((strCount[c]?: 0) <= (arrCount[c] ?: 0)) {
                    charMatches--
                }
                strCount[c] = strCount[c]!! - 1
                l++
            } else {
                if (r > str.lastIndex) break
                // expand window
                val c = str[r] // y

                if ((strCount[c] ?: 0) < (arrCount[c] ?: 0)) {
                    charMatches++
                }

                strCount[c] = (strCount[c] ?: 0) + 1
                currWindow += c
                r++
            }
        }

        return best
    }
}
