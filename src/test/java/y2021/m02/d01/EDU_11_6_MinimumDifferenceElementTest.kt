package y2021.m02.d01

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_11_6_MinimumDifferenceElementTest {

    val c = EDU_11_6_MinimumDifferenceElement()

    @Test
    fun tc1() {
        assertEquals(6, c.searchMinDiffElement(listOf(4, 6, 10), 7))
    }

    @Test
    fun tc2() {
        assertEquals(4, c.searchMinDiffElement(listOf(4, 6, 10), 4))
    }

    @Test
    fun tc3() {
        assertEquals(10, c.searchMinDiffElement(listOf(1, 3, 8, 10, 15), 12))
    }

    @Test
    fun tc4() {
        assertEquals(10, c.searchMinDiffElement(listOf(4, 6, 10), 17))
    }
}
