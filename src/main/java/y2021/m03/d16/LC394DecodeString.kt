package y2021.m03.d16

class LC394DecodeString {
    fun decodeString(s: String): String {
        var head = ""
        var mid = ""

        var openCount = 0
        var hitOpen = false
        for (i in s.indices) {
            val c = s[i]
            if (c == '[') {
                if (hitOpen) mid += '['
                hitOpen = true
                openCount++
            } else if (c == ']') {
                openCount--
                if (openCount == 0) {
                    val numS = head.takeLastWhile { it in '0'..'9' }
                    val times = Integer.parseInt(numS)
                    val newHead = head.dropLast(numS.length)
                    val tail = s.substring(i + 1..s.lastIndex)
                    return newHead + decodeString(mid).repeat(times) + decodeString(tail)
                } else {
                    mid += ']'
                }
            } else if (!hitOpen) {
                head += c
            } else {
                mid += c
            }
        }
        return s
    }
}
