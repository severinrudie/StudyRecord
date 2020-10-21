package y2020.m10.d21

import org.junit.jupiter.api.Test
import y2020.m10.d21.EDU3LongestSubstringKDistinct.findLength
import y2020.m10.d21.EDU3LongestSubstringKDistinct.getUniques
import kotlin.test.assertEquals

internal class EDU3LongestSubstringKDistinctTest {

    @Test
    fun tc1() {
        assertEquals(3, getUniques(mapOf(1 to 1, 2 to 2, 3 to 3, 4 to 0, 5 to 0)))
    }

    @Test
    fun tc2() {
        assertEquals(4, findLength("araaci", 2))
    }

}