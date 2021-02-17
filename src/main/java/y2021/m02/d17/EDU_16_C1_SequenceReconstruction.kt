package y2021.m02.d17

class EDU_16_C1_SequenceReconstruction {
    // O(v + e) time, O(v + e) space
    fun canConstruct(original: IntArray, sequences: Array<IntArray>): Boolean {
        val degrees = mutableMapOf<Int, Int>()
        val children = mutableMapOf<Int, List<Int>>()

        for (seq in sequences) {
            for (i in 1..seq.lastIndex) {
                val prev = seq[i - 1]
                val curr = seq[i]

                degrees[curr] = (degrees[curr] ?: 0) + 1
                degrees[prev] = degrees[prev] ?: 0
                children[prev] = (children[prev] ?: emptyList()) + curr
                children[curr] = children[curr] ?: emptyList()
            }
        }

        val actionable = degrees.filter { (k,v) -> v == 0 }
            .map { (k,v) -> k }
            .toMutableList()
        var checked = 0
        while (actionable.isNotEmpty()) {
            if (actionable.size > 1) return false
            val next = actionable.removeAt(0)
            checked++

            for (child in children[next]!!) {
                degrees[child] = degrees[child]!! - 1
                if (degrees[child] == 0) actionable += child
            }
        }
        return checked == original.size
    }

}