package y2021.m02.d14

import java.util.*

class EDU_16_3_TasksSchedulingOrder {
    // O(v + e) time, O(v + e) space
    fun findOrder(tasks: Int, prereqs: Array<IntArray>): List<Int> {
        val parentCount = mutableMapOf<Int, Int>()
        val children = mutableMapOf<Int, List<Int>>()

        for (i in 0 until tasks) {
            parentCount[i] = 0
            children[i] = emptyList()
        }

        for (prereq in prereqs) {
            val parent = prereq[0]
            val child = prereq[1]
            children[parent] = children[parent]!! + child
            parentCount[child] = parentCount[child]!! + 1
        }

        val actionable = LinkedList<Int>()
        for ((node, count) in parentCount) {
            if (count == 0) actionable += node
        }

        val sortedOrder = mutableListOf<Int>()
        while (actionable.isNotEmpty()) {
            val next = actionable.poll()
            sortedOrder += next
            for (child in children[next]!!) {
                parentCount[child] = parentCount[child]!! - 1
                if (parentCount[child] == 0) actionable += child
            }
        }
        if (sortedOrder.size != tasks) return emptyList()
        else return sortedOrder
    }

}