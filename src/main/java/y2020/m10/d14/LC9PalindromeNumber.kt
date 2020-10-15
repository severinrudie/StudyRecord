package y2020.m10.d14

// Easy, 48% acceptance
// O(n) time, O(n) space
object LC9PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        var mutX = x
        val digits = mutableListOf<Int>()
        while (mutX > 0) {
            val next = mutX % 10
            mutX = (mutX - next) / 10
            digits += next
        }

        val steps = if (x % 2 == 0) digits.size / 2 else (digits.size / 2) + 1
        for (front in 0 until steps) {
            val back = digits.lastIndex - front
            if (digits[front] != digits[back]) return false
        }
        return true
    }
}
