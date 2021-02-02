package y2021.m02.d02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_13_2_KthSmallestNumberTest {

    val c = EDU_13_2_KthSmallestNumber()

    @Test
    fun tc1() {
        val input = intArrayOf(1, 5, 12, 2, 11, 5)
        val k = 3
        val expect = 5

        assertEquals(expect, c.findKthSmallestNumber(input, k))
    }

    @Test
    fun tc2() {
        val input = intArrayOf(1, 5, 12, 2, 11, 5)
        val k = 4
        val expect = 5

        assertEquals(expect, c.findKthSmallestNumber(input, k))
    }

    @Test
    fun tc3() {
        val input = intArrayOf(5, 12, 11, -1, 12)
        val k = 3
        val expect = 11

        assertEquals(expect, c.findKthSmallestNumber(input, k))
    }
}
