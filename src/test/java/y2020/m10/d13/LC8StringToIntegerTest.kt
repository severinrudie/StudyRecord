package y2020.m10.d13

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import y2020.m10.d13.LC8StringToInteger.myAtoi

internal class LC8StringToIntegerTest {
    @Test
    fun tc1() {
        assertEquals(-42, myAtoi("-42"))
    }

    @Test
    fun tc2() {
        assertEquals(-42, myAtoi("    -42"))
    }

    @Test
    fun tc3() {
        assertEquals(-42, myAtoi("    -42aasdf"))
    }

    @Test
    fun tc4() {
        assertEquals(42, myAtoi("    42"))
    }

    @Test
    fun tc5() {
        assertEquals(0, myAtoi("f    -42aasdf"))
    }

    @Test
    fun tc6() {
        assertEquals(-42, myAtoi("    -42 aasdf   "))
    }

    @Test
    fun tc7() {
        assertEquals(-2147483648, myAtoi("-91283472332"))
    }

    @Test
    fun tc8() {
        assertEquals(-2147483648, myAtoi("-2147483649"))
        assertEquals(-2147483648, myAtoi("-2147483648"))
    }

    @Test
    fun tc9() {
        assertEquals(2147483647, myAtoi("2147483648"))
        assertEquals(2147483647, myAtoi("2147483647"))
    }

    @Test
    fun tc10() {
        assertEquals(42, myAtoi("+42"))
    }

    @Test
    fun tc11() {
        assertEquals(4193, myAtoi("4193 with words"))
    }

    @Test
    fun tc12() {
        assertEquals(-2147483648, myAtoi("-91283472332"))
    }

    @Test
    fun tc13() {
        assertEquals(2147483647, myAtoi("91283472332"))
    }

    @Test
    fun tc14() {
        assertEquals(0, myAtoi("+-12"))
    }

    @Test
    fun tc15() {
        assertEquals(12345678, myAtoi("  0000000000012345678"))
    }

    @Test
    fun tc16() {
        assertEquals(0, myAtoi("00000-42a1234"))
    }

    @Test
    fun tc17() {
        assertEquals(1095502006, myAtoi("1095502006p8"))
    }
}
