package y2021.m01.d29

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import y2021.m02.d01.EDU_11_3_NextLetter

internal class EDU_11_3_NextLetterTest {
    val c = EDU_11_3_NextLetter()

    @Test
    fun tc1() {
        assertEquals('h', c.searchNextLetter(charArrayOf('a', 'c', 'f', 'h'), 'f'))
    }

    @Test
    fun tc2() {
        assertEquals('c', c.searchNextLetter(charArrayOf('a', 'c', 'f', 'h'), 'b'))
    }

    @Test
    fun tc3() {
        assertEquals('a', c.searchNextLetter(charArrayOf('a', 'c', 'f', 'h'), 'm'))
    }

    @Test
    fun tc4() {
        assertEquals('a', c.searchNextLetter(charArrayOf('a', 'c', 'f', 'h'), 'h'))
    }
}