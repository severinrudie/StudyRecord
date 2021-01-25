package y2021.m01.d25

class Pramp_DecryptMessage {

    fun encrypt(word: String): String {
        var prev = 1
        var result = ""
        for (c in word) {
            result += c + prev
            prev = result.last().toInt()
        }
        return result.map { c ->
            ((c - 'a') % 26 + 'a'.toInt()).toChar()
        }.joinToString(separator = "")
    }

    // O(n) time, O(n) space
    fun decrypt(word: String): String {
        val result = StringBuilder()
        for (i in word.indices) {
            val c = word[i]
            val subtract: Int = if (i == 0) {
                1
            } else {
                word[i - 1].toInt()
            }
            var rotated = c.toInt() - (subtract % 26)
            if (rotated < 'a'.toInt()) rotated += 26

            result.append(rotated.toChar())
        }
        return result.toString()
    }
}
