package y2021.m02.d04

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class EDU_13_C3_FrequencyStackTest {

    lateinit var stack: EDU_13_c3_FrequencyStack

    @BeforeEach
    fun setup() {
        stack = EDU_13_c3_FrequencyStack()
    }

    @Test
    fun tc1() {
        listOf(1,2,3,2,1,2,5).forEach { stack.push(it) }

        assertEquals(2, stack.pop())
        assertEquals(1, stack.pop())
        assertEquals(2, stack.pop())
    }
}
