package y2021.m02.d01

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_11_7_BitronicArrayMaximumTest {

    val c = EDU_11_7_BitronicArrayMaximum()

    @Test
    fun tc1() {
        assertEquals(12, c.findMax(intArrayOf(1, 3, 8, 12, 4, 2)))
    }

    @Test
    fun tc2() {
        assertEquals(8, c.findMax(intArrayOf(3, 8, 3, 1)))
    }

    @Test
    fun tc3() {
        assertEquals(12, c.findMax(intArrayOf(1, 3, 8, 12)))
    }

    @Test
    fun tc4() {
        assertEquals(10, c.findMax(intArrayOf(10, 9, 8)))
    }
}
