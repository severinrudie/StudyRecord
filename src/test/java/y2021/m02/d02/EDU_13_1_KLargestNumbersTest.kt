package y2021.m02.d02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_13_1_KLargestNumbersTest {

    val c = EDU_13_1_KLargestNumbers()

    @Test
    fun tc1() {
        val input = intArrayOf(3, 1, 5, 12, 2, 11)
        val expect = listOf(5, 12, 11).sorted()
        assertEquals(expect, c.findKLargestNumbers(input, expect.size).sorted())
    }

    @Test
    fun tc2() {
        val input = intArrayOf(5, 12, 11, -1, 12)
        val expect = listOf(12, 11, 12).sorted()
        assertEquals(expect, c.findKLargestNumbers(input, expect.size).sorted())
    }
}
