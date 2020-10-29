package y2020.m10.d29

import org.junit.jupiter.api.Test
import shared.Interval
import y2020.m10.d29.EDU_4_3_IntervalsIntersection.merge
import kotlin.test.assertEquals

internal class EDU_4_3_IntervalsIntersectionTest {
    @Test
    fun tc1() {
        assertEquals(
                Interval.listOf(2..3, 5..6, 7..7),
                merge(
                        Interval.listOf(1..3,5..6,7..9).toTypedArray(),
                        Interval.listOf(2..3,5..7).toTypedArray()
                ).toList()
        )
    }


}