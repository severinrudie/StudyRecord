package y2021.m03.d03

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LC681NextClosestTimeTest {
    val c = LC681NextClosestTime()

    @Test
    fun tc1() {
        val input = "19:34"
        val expect = "19:39"

        assertEquals(expect, c.nextClosestTime(input))
    }
}
