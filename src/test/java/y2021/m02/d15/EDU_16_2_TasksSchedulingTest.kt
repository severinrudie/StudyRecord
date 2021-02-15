package y2021.m02.d15

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import y2021.m02.d14.EDU_16_2_TasksScheduling

internal class EDU_16_2_TasksSchedulingTest {

    val c = EDU_16_2_TasksScheduling()

    @Test
    fun tc1() {
        val tasks = 3
        val prereqs = arrayOf(intArrayOf(0,1), intArrayOf(1,2))
        val expect = true
        assertEquals(expect, c.isSchedulingPossible(tasks, prereqs))
    }

    @Test
    fun tc2() {
        val tasks = 3
        val prereqs = arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(2,0))
        val expect = false
        assertEquals(expect, c.isSchedulingPossible(tasks, prereqs))
    }

    @Test
    fun tc3() {
        val tasks = 6
        val prereqs = arrayOf(intArrayOf(2, 5), intArrayOf(0, 5), intArrayOf(0, 4), intArrayOf(1, 4), intArrayOf(3, 2), intArrayOf(1, 3))
        val expect = true
        assertEquals(expect, c.isSchedulingPossible(tasks, prereqs))
    }
}
