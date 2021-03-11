package y2021.m03.d11

class LC1047RemoveAllAdjascentDuplicatesInString {
    fun removeDuplicates(s: String): String {
        val dupeIndices = BooleanArray(s.length) { false }
        var hasDupes = false
        var skipNext = false

        for (i in 0 until s.lastIndex) {
            if (!skipNext && s[i] == s[i + 1]) { //todo dont remove triples
                dupeIndices[i] = true
                dupeIndices[i + 1] = true
                hasDupes = true
                skipNext = true
                // i++
            } else {
                skipNext = false
            }
        }

        var result = StringBuilder()
        for (i in s.indices) {
            if (dupeIndices[i] == false) result.append(s[i])
        }

        if (hasDupes) return removeDuplicates(result.toString())
        else return result.toString()
    }
}