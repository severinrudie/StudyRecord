package y2020.m10.d23

import org.junit.jupiter.api.Test
import y2020.m10.d23.EDU_2_5_TripletSumCloseToTarget.searchTriplet
import kotlin.test.assertEquals

internal class EDU_2_5_TripletSumCloseToTargetTest {

    @Test
    fun tc1() {
        assertEquals(1, searchTriplet(intArrayOf(-2,0,1,2), 2))
    }

    @Test
    fun tc2() {
        assertEquals(3, searchTriplet(intArrayOf(1,0,1,1), 100))
    }
}