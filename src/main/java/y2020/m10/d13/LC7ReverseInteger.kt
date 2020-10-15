package y2020.m10.d13

// Brute force.  Slow due to string allocation
object LC7ReverseInteger {
    fun reverse(x: Int): Int {
        val reversedUnsigned = x.toString().replace("-", "").reversed().toLong()
        val reversedSigned = if (x < 0) {
            0 - reversedUnsigned
        } else {
            reversedUnsigned
        }

        return if (reversedSigned > Int.MAX_VALUE || reversedSigned < Int.MIN_VALUE) {
            0
        } else {
            reversedSigned.toInt()
        }
    }
}