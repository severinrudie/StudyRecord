package y2021.m02.d19

import kotlin.math.max

// TODO there is an O(v + e) time, O(v + e) space solution

class EDU_16_C2_MinimumHeightGraphs {
    // O(v e) time, O(v ^ 2) space
    fun findTrees(nodes: Int, edges: Array<IntArray>): List<Int> {
        val children = mutableMapOf<Int, List<Int>>()
        for (edge in edges) {
            val n1 = edge[0]
            val n2 = edge[1]
            children[n1] = (children[n1] ?: emptyList()) + n2
            children[n2] = (children[n2] ?: emptyList()) + n1
        }

        return getMaxDepth(children)
    }

    private fun getMaxDepth(
        children: Map<Int, List<Int>>,
        mem: Array<IntArray> = Array(children.size) { IntArray(children.size) { -1 } }
    ): List<Int> {
        var min = Int.MAX_VALUE
        val bestNodes = mutableListOf<Int>()
        for ((child, _) in children) {
            val newDepth = getMaxDepth(child, child, children, mem)
            if (newDepth < min) {
                bestNodes.clear()
                min = newDepth
            }
            if (newDepth == min) {
                bestNodes += child
            }
        }
        return bestNodes
    }

    private fun getMaxDepth(
        from: Int,
        curr: Int,
        children: Map<Int, List<Int>>,
        mem: Array<IntArray>
    ): Int {
        if (mem[curr][from] != -1) return mem[curr][from]

        var max = 1
        for (child in children[curr]!!) {
            if (child == from) continue
            max = max(max, getMaxDepth(curr, child, children, mem) + 1)
        }

        mem[curr][from] = max
        return max
    }

}
