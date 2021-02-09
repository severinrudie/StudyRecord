package y2021.m02.d09

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_15_C1_CountOfSubsetSumTest {

    val c = EDU_15_C1_CountOfSubsetSum()

    @Test
    fun tc1() {
        val arr = intArrayOf(1,2,7,1,5)
        val sum = 9
        val expect = 3
        assertEquals(expect, c.countSubsets(arr, sum))
    }

    @Test
    fun tc2() {
        val arr = intArrayOf(1, 1, 2, 3)
        val sum = 4
        val expect = 3
        assertEquals(expect, c.countSubsets(arr, sum))
    }
}