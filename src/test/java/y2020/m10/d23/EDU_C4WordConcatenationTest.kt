package y2020.m10.d23

import org.junit.jupiter.api.Test
import y2020.m10.d23.EDU_C4WordConcatenation.findWordConcatenation
import kotlin.test.assertEquals

internal class EDU_C4WordConcatenationTest {

    @Test
    fun tc1() {
        assertEquals(listOf(0,3), findWordConcatenation("catfoxcat", arrayOf("cat", "fox")))
    }

}