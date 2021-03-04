package y2021.m03.d03

class LC482LicenseKeyFormatting {
    // O(n) time, O(n) space
    fun licenseKeyFormatting(s: String, k: Int): String {
        val raw = s.filter { it != '-' }.toUpperCase()

        val firstGroup = raw.length % k

        var result = ""
        var count = 0
        for (i in raw.lastIndex downTo 0) {
            result = raw[i] + result
            count++
            if (count == k && i != 0) {
                result = '-' + result
                count = 0
            }
        }
        return result
    }
}