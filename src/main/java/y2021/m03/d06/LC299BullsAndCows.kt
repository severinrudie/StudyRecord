package y2021.m03.d06

import kotlin.math.min

class LC299BullsAndCows {
    fun getHint(secret: String, guess: String): String {
        if (secret.length != guess.length) throw RuntimeException()

        val secretChars = mutableMapOf<Char, Int>()
        val guessChars = mutableMapOf<Char, Int>()
        var correct = 0

        for (i in secret.indices) {
            val c1 = secret[i]
            val c2 = guess[i]

            if (c1 == c2) correct++
            else {
                secretChars[c1] = (secretChars[c1] ?: 0) + 1
                guessChars[c2] = (guessChars[c2] ?: 0) + 1
            }
        }

        var wrongPos = 0
        for (guessC in guessChars.keys) {
            val guessCount = guessChars[guessC]!!
            val secretCount = secretChars[guessC] ?: 0

            wrongPos += min(guessCount, secretCount)
        }

        return "${correct}A${wrongPos}B"
    }
}