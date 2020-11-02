package y2020.m11.d2

import org.junit.jupiter.api.Test
import y2020.m11.d2.EDU_5_C3_FirstKMissingPositive.findNumbers
import kotlin.test.assertEquals

internal class EDU_5_C3_FirstKMissingPositiveTest {
    @Test
    fun tc1() {
        assertEquals(
                listOf(1,2,6),
                findNumbers(intArrayOf(3,-1,4,5,5), 3)
        )
    }

    @Test
    fun tc2() {
        assertEquals(
                listOf(1,5,6),
                findNumbers(intArrayOf(2,3,4), 3)
        )
    }

    @Test
    fun tc3() {
        assertEquals(
                listOf(1,2),
                findNumbers(intArrayOf(-2,-3,4),2)
        )
    }
}