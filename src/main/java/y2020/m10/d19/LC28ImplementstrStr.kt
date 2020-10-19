package y2020.m10.d19

// Easy, 34%
// O(nm) time, O(1) space
object LC28ImplementstrStr {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0
        if (haystack.isEmpty()) return -1
        if (needle.length > haystack.length) return -1

        for (i in 0..haystack.lastIndex - (needle.length - 1)) {
            if (haystack[i] == needle[0]) {
                var matches = true
                for (j in needle.indices) {
                    if (haystack[i + j] != needle[j]) matches = false
                }
                if (matches) return i
            }
        }
        return -1
    }
}
