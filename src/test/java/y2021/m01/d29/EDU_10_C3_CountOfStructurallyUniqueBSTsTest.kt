package y2021.m01.d29

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class EDU_10_C3_CountOfStructurallyUniqueBSTsTest {

    val c = EDU_10_C3_CountOfStructurallyUniqueBSTs()

    @Test
    fun tc1() {
        assertEquals(2, c.countTrees(2))
    }

    @Test
    fun tc2() {
        assertEquals(5, c.countTrees(3))
    }
}
