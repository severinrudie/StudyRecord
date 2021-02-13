package y2021.m02.d13

import java.util.*

class EDU_16_1_TopologicalSort2 {
    // O(v + e) time, O(v + e) space
    fun sort(vertices: Int, edges: Array<IntArray>): List<Int> {
        val children = mutableMapOf<Int, List<Int>>()
        val parentCount = mutableMapOf<Int, Int>()

        for (vert in 0 until vertices) {
            children[vert] = emptyList()
            parentCount[vert] = 0
        }

        for (edge in edges) {
            val from = edge[0]
            val to = edge[1]
            children[from] = children[from]!! + to
            parentCount[to] = parentCount[to]!! + 1
        }

        val sorted = mutableListOf<Int>()
        val sources = LinkedList<Int>()
        for ((vert, parents) in parentCount) {
            if (parents == 0) sources += vert
        }

        while (sources.isNotEmpty()) {
            val next = sources.poll()
            sorted += next
            for (child in children[next]!!) {
                parentCount[child] = parentCount[child]!! - 1
                if (parentCount[child] == 0) sources += child
            }
        }

        return sorted
    }
}
