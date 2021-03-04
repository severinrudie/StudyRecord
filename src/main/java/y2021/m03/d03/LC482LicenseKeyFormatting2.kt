package y2021.m03.d03

import java.util.*

class LC482LicenseKeyFormatting2 {
    // Optimized.  Same complexity, but about 6x faster (per LC) by avoiding string concat
    // O(n) time, O(n) space
    fun licenseKeyFormatting(s: String, k: Int): String {
        val chars = LinkedList<Char>()

        for (c in s) {
            if (c != '-') chars.addLast(c)
        }

        val result = LinkedList<Char>()
        val firstSize = chars.size % k
        for (i in 0 until firstSize) {
            result.addLast(chars.removeFirst().toUpperCase())
        }

        while (chars.isNotEmpty()) {
            if (result.isNotEmpty()) result.addLast('-')
            for (i in 0 until k) result.addLast(chars.removeFirst().toUpperCase())
        }

        return result.joinToString(separator = "")
    }
}
