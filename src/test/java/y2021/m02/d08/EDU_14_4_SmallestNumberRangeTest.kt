package y2021.m02.d08

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_14_4_SmallestNumberRangeTest {

    val c = EDU_14_4_SmallestNumberRange()

    @Test
    fun tc1() {
        val input = listOf(intArrayOf(1,5,8), intArrayOf(4,12), intArrayOf(7,8,10))
        val expect = intArrayOf(4,7)
        val actual = c.findSmallestRange(input)
        assertArrayEquals(expect,actual)
    }

    @Test
    fun tc2() {
        val input = listOf(intArrayOf(1,9), intArrayOf(4,12), intArrayOf(7,10,16))
        val expect = intArrayOf(9,12)
        val actual = c.findSmallestRange(input)
        assertArrayEquals(expect,actual)
    }
}
