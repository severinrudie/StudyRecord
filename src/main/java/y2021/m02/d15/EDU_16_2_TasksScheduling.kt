package y2021.m02.d14

import java.util.*

class EDU_16_2_TasksScheduling {

    // O(v + e) time, O(v + e) space
    fun isSchedulingPossible(tasks: Int, prerequisites: Array<IntArray>): Boolean {
        val parentCount = mutableMapOf<Int, Int>()
        val children = mutableMapOf<Int, List<Int>>()

        for (i in 0 until tasks) {
            parentCount[i] = 0
            children[i] = emptyList()
        }

        for ((parent, child) in prerequisites) {
            parentCount[child] = parentCount[child]!! + 1
            children[parent] = children[parent]!! + child
        }

        val actionable = LinkedList<Int>()
        for ((node, count) in parentCount) {
            if (count == 0) actionable += node
        }

        var ran = 0
        while (actionable.isNotEmpty()) {
            val next = actionable.poll()
            ran++
            for (child in children[next]!!) {
                parentCount[child] = parentCount[child]!! - 1
                if (parentCount[child] == 0) actionable += child
            }
        }
        return tasks == ran
    }
}
