package y2020.m10.d30

import org.junit.jupiter.api.Test
import shared.Interval
import y2020.m10.d30.EDU_4_C3_FindEmployeeFreeTime.findEmployeeFreeTime
import kotlin.test.assertEquals

internal class EDU_4_C3_FindEmployeeFreeTimeTest {
    @Test
    fun tc1() {
        assertEquals(
                Interval.listOf(3..5),
                findEmployeeFreeTime(mutableListOf(
                        Interval.listOf(1..3,5..6),
                        Interval.listOf(2..3,6..8)
                ))
        )
    }

    @Test
    fun tc2() {
        assertEquals(
                Interval.listOf(4..6,8..9),
                findEmployeeFreeTime(mutableListOf(
                        Interval.listOf(1..3,9..12),
                        Interval.listOf(2..4),
                        Interval.listOf(6..8)
                ))
        )
    }

    @Test
    fun tc3() {
        assertEquals(
                Interval.listOf(5..7),
                findEmployeeFreeTime(mutableListOf(
                        Interval.listOf(1..3),
                        Interval.listOf(2..4),
                        Interval.listOf(3..5),
                        Interval.listOf(7..9)
                ))
        )
    }
}
