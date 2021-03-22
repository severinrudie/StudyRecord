package y2021.m03.d22

class LC797AllPathsFromSourceToTarget {
    // O(n^2) time, O(n^2) space
    fun allPathsSourceTarget(
        nodes: Array<IntArray>,
        currIndex: Int = 0,
        stem: List<Int> = emptyList(),
        mem: MutableMap<Int, List<List<Int>>> = mutableMapOf()
    ): List<List<Int>> {
        if (mem[currIndex] != null) return mem[currIndex]!!
        if (currIndex == nodes.lastIndex) return listOf(stem + currIndex)

        val children = nodes[currIndex]
        val result = mutableListOf<List<Int>>()

        for (i in children) {
            result += allPathsSourceTarget(nodes, i, stem + currIndex)
        }

        mem[currIndex] = result
        return result
    }
}