package y2021.m02.d04

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_13_C2_SchedulingTasksTest {

    val c = EDU_13_C2_SchedulingTasks()

    @Test
    fun tc1() {
        assertEquals(7, c.scheduleTasks(charArrayOf('a','a','a','b','c','c'), 2))
    }

    @Test
    fun tc2() {
        assertEquals(5, c.scheduleTasks(charArrayOf('a','b','a'), 3))
    }
}
