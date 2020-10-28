package y2020.m10.d28

import org.junit.jupiter.api.Test
import y2020.m10.d28.EDU_3_C3_CircularArrayLoop.loopExists
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class EDU_3_C3_CircularArrayLoopTest {
    @Test
    fun tc1() {
        assertTrue(loopExists(intArrayOf(1,2,-1,2,2)))
    }

    @Test
    fun tc2() {
        assertTrue(loopExists(intArrayOf(2,2,-1,2)))
    }

    @Test
    fun tc3() {
        assertFalse(loopExists(intArrayOf(2,1,-1,-2)))
    }
}