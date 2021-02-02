package y2021.m02.d02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_12_C1_FlipAndInvertImageTest {

    val c = EDU_12_C1_FlipAndInvertImage()

    @Test
    fun tc1() {
        val input = arrayOf(
            arrayOf(1, 1, 0, 0),
            arrayOf(1, 0, 0, 1),
            arrayOf(0, 1, 1, 1),
            arrayOf(1, 0, 1, 0)
        )
        val expect = arrayOf(
            arrayOf(1, 1, 0, 0),
            arrayOf(0, 1, 1, 0),
            arrayOf(0, 0, 0, 1),
            arrayOf(1, 0, 1, 0)
        )
        assertArrayEquals(expect, c.flipAndInvertImage(input))
    }


    @Test
    fun tc2() {
        val input = arrayOf(
            arrayOf(1, 0, 1),
            arrayOf(1, 1, 1),
            arrayOf(0, 1, 1)
        )
        val expect = arrayOf(
            arrayOf(0, 1, 0),
            arrayOf(0, 0, 0),
            arrayOf(0, 0, 1)
        )
    }
}
