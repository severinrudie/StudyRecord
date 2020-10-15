package y2020.m10.d14

// Easy, 56%
// O(n)
object LC13RomanToInteger {

    fun romanToInt(s: String): Int {
        var s = s
        var total = 0
        while (s.isNotEmpty()) {
            if (s.length >= 2 && numerals.contains(s.take(2))) {
                val numeral = s.take(2)
                s = s.drop(2)
                total += numerals[numeral]!!
            } else {
                val numeral = s.take(1)
                s = s.drop(1)
                total += numerals[numeral]!!
            }
        }
        return total
    }

    val numerals = mapOf(
            "M" to 1000,
            "CM" to 900,
            "D" to 500,
            "CD" to 400,
            "C" to 100,
            "XC" to 90,
            "L" to 50,
            "XL" to 40,
            "X" to 10,
            "IX" to 9,
            "V" to 5,
            "IV" to 4,
            "I" to 1
    )
}