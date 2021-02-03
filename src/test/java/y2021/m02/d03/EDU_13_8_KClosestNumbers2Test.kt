package y2021.m02.d03

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_13_8_KClosestNumbers2Test {

    val c = EDU_13_8_KClosestNumbers2()

    @Test
    fun tc1() {
        val input = intArrayOf(5, 6, 7, 8, 9)
        val expectSize = 3
        val target = 7
        val expected = listOf(6,7,8)
        assertEquals(expected, c.findClosestElements(input, expectSize, target).sorted())
    }

    @Test
    fun tc2() {
        val input = intArrayOf(2, 4, 5, 6, 9)
        val expectSize = 3
        val target = 6
        val expected = listOf(4,5,6)
        assertEquals(expected, c.findClosestElements(input, expectSize, target).sorted())
    }

    @Test
    fun tc3() {
        val input = intArrayOf(2, 4, 5, 6, 9)
        val expectSize = 3
        val target = 10
        val expected = listOf(5,6,9)
        assertEquals(expected, c.findClosestElements(input, expectSize, target).sorted())
    }
}