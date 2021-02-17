package y2021.m02.d17

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_16_5_AlienDictionaryTest {

    val c = EDU_16_5_AlienDictionary()

    @Test
    fun tc1() {
        val input = listOf("ba", "bc", "ac", "cab")
        val expect = "bac"
        assertEquals(expect, c.findOrder(input))
    }

    @Test
    fun tc2() {
        val input = listOf("cab", "aaa", "aab")
        val expect = "cab"
        assertEquals(expect, c.findOrder(input))
    }

    @Test
    fun tc3() {
        val input = listOf("ywx", "wz", "xww", "xz", "zyy", "zwz")
        val expect = "ywxz"
        assertEquals(expect, c.findOrder(input))
    }
}