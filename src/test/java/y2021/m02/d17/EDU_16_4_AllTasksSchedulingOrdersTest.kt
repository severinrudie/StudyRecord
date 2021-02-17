package y2021.m02.d17

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EDU_16_4_AllTasksSchedulingOrdersTest {

    val c = EDU_16_4_AllTasksSchedulingOrders()

    @Test
    fun tc1() {
        val tasks = 3
        val prereqs = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        val expect = listOf(listOf(0, 1, 2))
        assertEquals(expect, c.printOrders(tasks, prereqs))
    }

    @Test
    fun tc2() {
        val tasks = 4
        val prereqs = arrayOf(intArrayOf(3, 2), intArrayOf(3, 0), intArrayOf(2, 0), intArrayOf(2, 1))
        val expect = listOf(
            listOf(3, 2, 0, 1),
            listOf(3, 2, 1, 0),
        )
        assertEquals(expect, c.printOrders(tasks, prereqs))
    }

    @Test
    fun tc3() {
        val tasks = 6
        val prereqs = arrayOf(
            intArrayOf(2, 5),
            intArrayOf(0, 5),
            intArrayOf(0, 4),
            intArrayOf(1, 4),
            intArrayOf(3, 2),
            intArrayOf(1, 3)
        )
        val expect = listOf(
            listOf(0, 1, 4, 3, 2, 5),
            listOf(0, 1, 3, 4, 2, 5),
            listOf(0, 1, 3, 2, 4, 5),
            listOf(0, 1, 3, 2, 5, 4),
            listOf(1, 0, 3, 4, 2, 5),
            listOf(1, 0, 3, 2, 4, 5),
            listOf(1, 0, 3, 2, 5, 4),
            listOf(1, 0, 4, 3, 2, 5),
            listOf(1, 3, 0, 2, 4, 5),
            listOf(1, 3, 0, 2, 5, 4),
            listOf(1, 3, 0, 4, 2, 5),
            listOf(1, 3, 2, 0, 5, 4),
            listOf(1, 3, 2, 0, 4, 5),
        ).sort()
        assertEquals(expect, c.printOrders(tasks, prereqs).sort())
    }

    fun List<List<Int>>.sort(): List<List<Int>> {
        return this.sortedWith { a, b ->
            for (i in a.indices) {
                if (a[i] == b[i]) continue
                return@sortedWith a[i] - b[i]
            }
            return@sortedWith 0
        }
    }
}
