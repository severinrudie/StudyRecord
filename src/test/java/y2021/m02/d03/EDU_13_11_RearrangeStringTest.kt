package y2021.m02.d03

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import y2021.m02.d04.EDU_13_11_RearrangeString

internal class EDU_13_11_RearrangeStringTest {

    val c = EDU_13_11_RearrangeString()

    @Test
    fun tc1() {
        assertEquals("papap", c.rearrangeString("aappp"))
    }

    @Test
    fun tc2() {
        assertEquals("rgmrgmoaPin", c.rearrangeString("Programming"))
    }

    @Test
    fun tc3() {
        assertEquals(null, c.rearrangeString("aapa"))
    }
}
