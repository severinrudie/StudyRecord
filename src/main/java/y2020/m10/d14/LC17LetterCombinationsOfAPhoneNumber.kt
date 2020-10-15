package y2020.m10.d14

import java.lang.RuntimeException

// Medium, 47%
// O(3^n)
object LC17LetterCombinationsOfAPhoneNumber {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        var strs = emptyList<String>()

        digits.forEach { num ->
            val newChars = num.toChars()
            strs = strs.flatMap { prev ->
                newChars.map { new -> prev + new  }
            }
        }

        return strs
    }

    fun Char.toChars() = when (this) {
        '2' -> listOf("a", "b", "c")
        '3' -> listOf("d", "e", "f")
        '4' -> listOf("g", "h", "i")
        '5' -> listOf("j", "k", "l")
        '6' -> listOf("m", "n", "o")
        '7' -> listOf("p", "q", "r", "s")
        '8' -> listOf("t", "u", "v")
        '9' -> listOf("w", "x", "y", "z")
        else -> throw RuntimeException()
    }
}
