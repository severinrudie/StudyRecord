package y2021.m01.d29

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_11_2_CeilingOfAKeyTest {

    val c = EDU_11_2_CeilingOfAKey()

    @Test
    fun tc1() {
        assertEquals(1, c.searchCeilingOfANumber(intArrayOf(4, 6, 10), 6))
    }

    @Test
    fun tc2() {
        assertEquals(4, c.searchCeilingOfANumber(intArrayOf(1, 3, 8, 10, 15), 12))
    }

    @Test
    fun tc3() {
        assertEquals(-1, c.searchCeilingOfANumber(intArrayOf(4, 6, 10), 17))
    }

    @Test
    fun tc4() {
        assertEquals(0, c.searchCeilingOfANumber(intArrayOf(4, 6, 10), -1))
    }
}