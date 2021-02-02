package y2021.m02.d02

class EDU_12_3_ComplementOfABaseTenNumber {
    // O(b) time [where b is the number of bits needed to store the number], O(1) space
    fun bitwiseComplement(n: Int): Int {
        var copy = n
        var mask = 1
        while (copy or 1 != 1) {
            copy = copy shr 1
            mask = (mask shl 1) + 1
        }

        return n xor mask
    }
}
