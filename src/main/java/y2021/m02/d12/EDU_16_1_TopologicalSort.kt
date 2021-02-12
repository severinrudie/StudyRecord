package y2021.m02.d12

class EDU_16_1_TopologicalSort {

    // Bad solution.  Will redo with a better one

    // O(e^2) time, O(v) space
    fun sort(vertices: Int, edges: Array<IntArray>): List<Int> {
        val result = mutableListOf<Int>()
        val added = mutableSetOf<Int>()

        var curr = mutableSetOf(-1)
        while (curr.isNotEmpty()) {
            curr = (0 until vertices).toMutableSet()
            for (edge in edges) {
                // if first hasnt been added, remove second
                // if second has been added, remove second

                if (edge[0] !in added) curr.remove(edge[1])
            }

            curr = curr.filter { it !in added }.toMutableSet()

            result += curr
            added += curr
        }
        return result
    }
}
