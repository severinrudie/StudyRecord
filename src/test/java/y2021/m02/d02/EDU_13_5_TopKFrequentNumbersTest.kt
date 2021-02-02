package y2021.m02.d02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_13_5_TopKFrequentNumbersTest {

    val c = EDU_13_5_TopKFrequentNumbers()

    @Test
    fun tc1() {
        val input = intArrayOf(1, 3, 5, 12, 11, 12, 11)
        val k = 2
        val expect = listOf(12, 11).sorted()
        assertEquals(expect, c.findTopKFrequentNumbers(input, k).sorted())
    }

    @Test
    fun tc2() {
        val input = intArrayOf(5, 12, 11, 3, 11)
        val k = 2
        val actual = c.findTopKFrequentNumbers(input, k).sorted()

        assertTrue(
            actual == listOf(5, 11) ||
            actual == listOf(11, 12) ||
            actual == listOf(3, 11)
        )
    }
}
