package y2021.m02.d04

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_13_C1_RearrangeStringKDistanceApartTest {

    val c = EDU_13_C1_RearrangeStringKDistanceApart()

    @Test
    fun tc1() {
        assertEquals("mpmp", c.reorganizeString("mmpp", 2))
    }

    @Test
    fun tc2() {
        assertEquals("rgmrgmoapin", c.reorganizeString("programming", 3))
    }

    @Test
    fun tc3() {
        assertEquals("aba", c.reorganizeString("aab", 2))
    }

    @Test
    fun tc4() {
        assertEquals(null, c.reorganizeString("aappa", 3))
    }
}
