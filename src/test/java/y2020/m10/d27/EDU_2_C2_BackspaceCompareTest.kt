package y2020.m10.d27

import org.junit.jupiter.api.Test
import y2020.m10.d27.EDU_2_C2_BackspaceCompare.compare
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class EDU_2_C2_BackspaceCompareTest {

    @Test
    fun tc1() {
        assertTrue(compare("xy#z", "xzz#"))
    }

    @Test
    fun tc2() {
        assertTrue(compare("xp#", "xyz##"))
    }

    @Test
    fun tc3() {
        assertFalse(compare("xy#z", "xyz##"))
    }

    @Test
    fun tc4() {
        assertTrue(compare("xywrrmp", "xywrrmu#p"))
    }
}
