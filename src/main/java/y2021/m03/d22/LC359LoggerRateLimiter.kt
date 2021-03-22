package y2021.m03.d22

class LC359LoggerRateLimiter {
    val map = mutableMapOf<String,Int>()

    // O(1) time, O(m) space [where m is distinct messages]
    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        val canBeShownAt = map[message] ?: 0

        return if (canBeShownAt <= timestamp) {
            map[message] = timestamp + 10
            true
        } else {
            false
        }
    }
}
