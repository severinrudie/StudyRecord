package y2021.m02.d09

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_15_2_EqualSubsetSumPartitionTest {

    val c = EDU_15_2_EqualSubsetSumPartition()

    @Test
    fun tc1() {
        val input = intArrayOf(1, 2, 3, 4)
        val expect = true
        assertEquals(expect, c.canPartition(input))
    }

    @Test
    fun tc2() {
        val input = intArrayOf(1, 1, 3, 4, 7)
        val expect = true
        assertEquals(expect, c.canPartition(input))
    }

    @Test
    fun tc3() {
        val input = intArrayOf(2, 3, 4, 6)
        val expect = false
        assertEquals(expect, c.canPartition(input))
    }

    @Test
    fun tc4() {
        val input = intArrayOf(1,2,5)
        val expect = false
        assertEquals(expect, c.canPartition(input))
    }
}
