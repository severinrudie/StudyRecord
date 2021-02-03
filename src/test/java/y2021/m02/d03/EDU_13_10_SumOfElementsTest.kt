package y2021.m02.d03

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_13_10_SumOfElementsTest {

    val c = EDU_13_10_SumOfElements()

    @Test
    fun tc1() {
        val arr = intArrayOf(1, 3, 12, 5, 15, 11)
        val k1 = 3
        val k2 = 6
        val expect = 23

        assertEquals(expect, c.findSumOfElements(arr, k1, k2))
    }

    @Test
    fun tc2() {
        val arr = intArrayOf(3, 5, 8, 7)
        val k1 = 1
        val k2 = 4
        val expect = 12

        assertEquals(expect, c.findSumOfElements(arr, k1, k2))
    }
}
