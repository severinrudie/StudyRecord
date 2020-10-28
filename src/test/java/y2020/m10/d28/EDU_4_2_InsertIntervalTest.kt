package y2020.m10.d28

import org.junit.jupiter.api.Test
import shared.Interval
import y2020.m10.d28.EDU_4_2_InsertInterval.insert
import kotlin.test.assertEquals

internal class EDU_4_2_InsertIntervalTest {
    @Test
    fun tc1() {
        assertEquals(
                Interval.listOf(1..3, 4..7, 8..12),
                insert(Interval.listOf(1..3,5..7,8..12), Interval(4..6))
        )
    }

    @Test
    fun tc2() {
        assertEquals(
                Interval.listOf(1..3,4..12),
                insert(Interval.listOf(1..3,5..7,8..12), Interval(4..10))
        )
    }

    @Test
    fun tc3() {
        assertEquals(
                Interval.listOf(1..3,4..12),
                insert(Interval.listOf(1..3,5..7,8..12), Interval(4..10))
        )
    }
}