package y2021.m02.d17


class EDU_16_4_AllTasksSchedulingOrders {
    // O(v! e) time, O(v! e) space
    fun printOrders(tasks: Int, prereqs: Array<IntArray>): List<List<Int>> {
        val degrees = mutableMapOf<Int, Int>()
        val children = mutableMapOf<Int, List<Int>>()

        for (i in 0 until tasks) {
            degrees[i] = 0
            children[i] = emptyList()
        }

        for (prereq in prereqs) {
            val parent = prereq[0]
            val child = prereq[1]

            degrees[child] = degrees[child]!! + 1
            children[parent] = children[parent]!! + child
        }

        return getOrders(listOf(emptyList()), degrees, children)
    }

    fun getOrders(stems: List<List<Int>>, degrees: MutableMap<Int, Int>, children: Map<Int, List<Int>>): List<List<Int>> {
        if (degrees.none { (k, v) -> v == 0 }) return stems
        val result = mutableListOf<List<Int>>()

        for ((node, degree) in degrees) {
            if (degree != 0) continue
            for (child in children[node]!!) {
                degrees[child] = degrees[child]!! - 1
            }
            degrees[node] = -1
            for (stem in stems) {
                result += getOrders(listOf(stem + node), degrees, children)
            }
            for (child in children[node]!!) {
                degrees[child] = degrees[child]!! + 1
            }
            degrees[node] = 0
        }
        return result
    }
}
