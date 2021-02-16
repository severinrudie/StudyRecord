package y2021.m02.d16


// TODO in progress.  needs to backtrack
class EDU_16_4_AllTasksSchedulingOrders {
    fun printOrders(tasks: Int, prereqs: Array<IntArray>): List<List<Int>> {
        val parentCounts = mutableMapOf<Int, Int>()
        val children = mutableMapOf<Int, List<Int>>()

        for (i in 0 until tasks) {
            parentCounts[i] = 0
            children[i] = emptyList()
        }

        for (prereq in prereqs) {
            val parent = prereq[0]
            val child = prereq[1]

            parentCounts[child] = parentCounts[child]!! + 1
            children[parent] = children[parent]!! + child
        }

        var actionable = mutableListOf<Int>()

        for ((node, count) in parentCounts) {
            if (count == 0) actionable.add(node)
        }

        var sortedLists = listOf(emptyList<Int>())

        while (actionable.isNotEmpty()) {
            sortedLists = getPermutations(sortedLists, actionable)
            val newActionable = mutableListOf<Int>()
            for (node in actionable) {
                for (child in children[node]!!) {
                    parentCounts[child] = parentCounts[child]!! - 1
                    if (parentCounts[child] == 0) newActionable += child
                }
            }
            actionable = newActionable
        }

        return sortedLists
    }

    fun getPermutations(stems: List<List<Int>>, plus: List<Int>): List<List<Int>> {
        if (plus.isEmpty()) return stems

        return stems.flatMap { stem ->
            plus.flatMap { num ->
                getPermutations(listOf(stem + num), plus - num)
            }
        }
    }
}
