package y2021.m02.d12

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_15_C2_TargetSumTest {

    val c = EDU_15_C2_TargetSum()

    @Test
    fun tc1() {
        val arr = intArrayOf(1,1,2,3)
        val target = 1
        val expect = 3
        assertEquals(expect, c.findTargetSubsets(arr, target))
    }

    @Test
    fun tc2() {
        val arr = intArrayOf(1,2,7,1)
        val target = 9
        val expect = 2
        assertEquals(expect, c.findTargetSubsets(arr, target))
    }
}
