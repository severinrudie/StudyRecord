package y2021.m02.d03

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_13_6_FrequencySortTest {

    val c = EDU_13_6_FrequencySort()

    @Test
    fun tc1() {
        val actual = c.sortCharacterByFrequency("Programming")
        assertEquals("rrggmm", actual.take(6))
        assertEquals(11, actual.length)
    }

    @Test
    fun tc2() {
        assertEquals("bbbaac", c.sortCharacterByFrequency("abcbab"))
    }
}
