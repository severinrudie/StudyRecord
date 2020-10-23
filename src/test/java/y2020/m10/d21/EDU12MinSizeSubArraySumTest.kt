package y2020.m10.d21

import org.junit.jupiter.api.Test
import y2020.m10.d21.EDU_1_2MinSizeSubArraySum.findMinSubArray
import kotlin.test.assertEquals

internal class EDU12MinSizeSubArraySumTest {

    @Test
    fun tc1() {
        assertEquals(1, findMinSubArray(5, intArrayOf(0,1,2,5,3,2,4)))
    }

    @Test
    fun tc2() {
        assertEquals(1, findMinSubArray(5, intArrayOf(0,1,2,3,2,4,5)))
    }

    @Test
    fun tc3() {
        assertEquals(2, findMinSubArray(7, intArrayOf(2, 1, 5, 2, 3, 2)))
    }

    @Test
    fun tc4() {
        //7, [2, 1, 5, 2, 8
        assertEquals(1, findMinSubArray(7, intArrayOf(2, 1, 5, 2, 8)))
    }

    @Test
    fun tc5() {
        assertEquals(3, findMinSubArray(8, intArrayOf(3, 4, 1, 1, 6)))
    }


}
