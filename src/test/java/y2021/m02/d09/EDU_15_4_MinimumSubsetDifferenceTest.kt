package y2021.m02.d09

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_15_4_MinimumSubsetDifferenceTest {

    val c = EDU_15_4_MinimumSubsetDifference()

    @Test
    fun tc1() {
        val input = intArrayOf(1,3,100,4)
        val expect = 92
        assertEquals(expect, c.canPartition(input))
    }

    @Test
    fun tc2() {
        val input = intArrayOf(1, 2, 7, 1, 5)
        val expect = 0
        assertEquals(expect, c.canPartition(input))
    }

    @Test
    fun tc3() {
        val input = intArrayOf(1, 2, 3, 9)
        val expect = 3
        assertEquals(expect, c.canPartition(input))
    }
}
