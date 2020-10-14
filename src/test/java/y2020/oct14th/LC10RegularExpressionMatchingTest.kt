package y2020.oct14th

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import y2020.oct14th.LC10RegularExpressionMatching.isMatch

internal class LC10RegularExpressionMatchingTest {

    @Test
    fun tc1() {
        test("aa", "a", false)
    }

    @Test
    fun tc2() {
        test("aa", "a*", true)
    }

    @Test
    fun tc3() {
        test("ab", ".*", true)
    }

    @Test
    fun tc4() {
        test("aab", "c*a*b", true)
    }

    @Test
    fun tc5() {
        test("aba", "c*a*b", false)
    }

    @Test
    fun tc6() {
        test("mississippi", "mis*is*p*.", false)
    }

    @Test
    fun tc7() {
        test("abbbbbbcdef","ab*bbcdef", true)
    }

    @Test
    fun tc8() {
        test("xyzabcd",".*abc", false)
    }

    @Test
    fun tc9() {
        test("aab","c*a**b", false)
    }

    private fun test(s: String, p: String, output: Boolean) {
        assertEquals(output, isMatch(s, p))
    }
}
