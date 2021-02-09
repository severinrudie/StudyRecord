package y2021.m02.d09

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_15_3_SubsetSumTest {

    val c = EDU_15_3_SubsetSum()

    @Test
    fun tc1() {
        val arr = intArrayOf(1,3,4,8)
        val sum = 6
        val expect = false
        assertEquals(expect, c.canPartition(arr, sum))
    }

    @Test
    fun tc2() {
        val arr = intArrayOf(1,2,7,1,5)
        val sum = 10
        val expect = true
        assertEquals(expect, c.canPartition(arr, sum))
    }

    @Test
    fun tc3() {
        val arr = intArrayOf(1,2,3,7)
        val sum = 6
        val expect = true
        assertEquals(expect, c.canPartition(arr, sum))
    }
}
