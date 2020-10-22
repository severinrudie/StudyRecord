package y2020.m10.d22

import org.junit.jupiter.api.Test
import y2020.m10.d22.EDU_C2StringAnagrams.findStringAnagrams
import kotlin.test.assertEquals

internal class EDU_C2StringAnagramsTest {

    @Test
    fun tc1() {
        assertEquals(listOf(1,2), findStringAnagrams("ppqp", "pq"))
    }

}