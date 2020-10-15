package y2020.m10.d13

import java.lang.RuntimeException

object LC8StringToInteger {
    fun myAtoi(s: String): Int {
        val regex = """^\s*([+-]?)(\d+).*""".toRegex()
        val match = regex.matchEntire(s)

        val rawSign = match?.groups?.get(1)?.value
        val sign = if (rawSign == "" || rawSign == null) "+" else rawSign
        val value = match?.groups?.get(2)?.value?.trimStart('0') ?: return 0

        if (sign.length != 1) return 0

        if (value.length > 10) {
            return if (sign == "+") 2147483647
            else -2147483648
        }
        if (value.isEmpty()) return 0
        if (value.length == 10) {
            val max = when (sign) {
                "+" -> "2147483647"
                "-" -> "2147483648"
                else -> throw RuntimeException()
            }

            val paired = value.zip(max)
            val firstUnequal = paired.indexOfFirst { it.first != it.second }
            val firstTooBig = paired.indexOfFirst { it.first > it.second }

            if (firstTooBig != -1 && (firstUnequal >= firstTooBig)) return (sign + max).toInt()
        }

        return (sign + value).toInt()
    }
}
