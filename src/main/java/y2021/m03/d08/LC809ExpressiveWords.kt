package y2021.m03.d08

class LC809ExpressiveWords {
    // O(nk) time, O(n + k) space
    fun expressiveWords(stretched: String, words: Array<String>): Int {
        val stretchChunked = stretched.chunked()

        var goodCount = 0
        for (word in words) {
            val wordChunked = word.chunked()
            if (stretchChunked.size != wordChunked.size) continue

            var good = true
            for (i in stretchChunked.indices) {
                val sChunk = stretchChunked[i]
                val wChunk = wordChunked[i]

                val firstCharDiff = sChunk[0] != wChunk[0]
                val sTooSmall = sChunk.length < wChunk.length
                val unequalSizes = sChunk.length != wChunk.length
                val shortSChunk = sChunk.length < 3

                if (
                    firstCharDiff ||
                    sTooSmall ||
                    (unequalSizes && shortSChunk)
                ) {
                    good = false
                    continue
                }
            }
            if (good) goodCount++
        }
        return goodCount
    }

    private fun String.chunked(): List<String> {
        if (this.isEmpty()) return emptyList()
        val result = mutableListOf<String>()
        var lastC = this[0]
        var building: String = ""
        for (c in this) {
            if (c == lastC) {
                building += c
            } else {
                result += building
                building = "" + c
                lastC = c
            }
        }
        result += building
        return result
    }
}
