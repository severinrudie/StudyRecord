package y2020.oct13th

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import y2020.oct13th.LC6ZigZagConversion.zigZagConversion

internal class LC6ZigZagConversionTest {

    @Test
    fun tc1() {
        assertEquals("PAHNAPLSIIGYIR", zigZagConversion("PAYPALISHIRING", 3))
    }

    @Test
    fun tc2() {
        assertEquals("A", zigZagConversion("A", 1))
    }

    @Test
    fun tc3() {
        assertEquals("A", zigZagConversion("A", 2))
    }

    @Test
    fun tc4() {
        assertEquals("AB", zigZagConversion("AB", 1))
    }


}
