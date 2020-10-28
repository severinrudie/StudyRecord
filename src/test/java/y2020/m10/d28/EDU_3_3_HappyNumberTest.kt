package y2020.m10.d28

import org.junit.jupiter.api.Test
import y2020.m10.d28.EDU_3_3_HappyNumber.find
import kotlin.test.assertEquals

internal class EDU_3_3_HappyNumberTest {

    @Test
    fun tc1() {
        assertEquals(false, find(12))
    }

    @Test
    fun tc2() {
        assertEquals(true, find(23))
    }

}