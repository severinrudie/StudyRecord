package y2021.m02.d04

import java.util.*

class EDU_13_C2_SchedulingTasks {

    data class Item(val c: Char, val count: Int, val availableAt: Int)

    // O(n log n) time, O(n) space
    fun scheduleTasks(tasks: CharArray, k: Int): Int {
        val counts = tasks.groupBy { it }.map { it.key to it.value.size }
        val maxHeap = PriorityQueue<Pair<Char, Int>> { a,b -> b.second - a.second }
        counts.forEach { maxHeap += it }

        var timeSpent = 0
        val cooling = LinkedList<Item>()
        while (true) {
            if (maxHeap.isEmpty() && cooling.isEmpty()) return timeSpent
            timeSpent++
            if (maxHeap.isNotEmpty()) {
                val next = maxHeap.poll()
                if (next.second > 1) {
                    cooling.addFirst(Item(next.first, next.second - 1, timeSpent + k))
                }
            }
            if (cooling.isNotEmpty()) {
                val lastCooling = cooling.peekLast()
                if (lastCooling.availableAt == timeSpent) {
                    cooling.removeLast()
                    maxHeap += lastCooling.c to lastCooling.count
                }
            }
        }
    }
}
