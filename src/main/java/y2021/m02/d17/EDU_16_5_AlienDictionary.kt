package y2021.m02.d17

import kotlin.math.min


class EDU_16_5_AlienDictionary {

    // O(v + n) time, O(v + n) space [where v is the number of distinct characters]
    fun findOrder(words: List<String>): String {
        val children = mutableMapOf<Char, List<Char>>()
        val degrees = mutableMapOf<Char, Int>()

        fun init(c: Char) {
            children[c] = children[c] ?: emptyList()
            degrees[c] = degrees[c] ?: 0
        }

        for (i in 1..words.lastIndex) {
            val word1 = words[i - 1]
            val word2 = words[i]

            for (c in 0 until min(word1.length, word2.length)) {
                val c1 = word1[c]
                val c2 = word2[c]

                if (c1 == c2) continue
                init(c1)
                init(c2)

                children[c1] = children[c1]!! + c2
                degrees[c2] = degrees[c2]!! + 1
                break
            }
        }

        val actionable = degrees.filter { (k, v) -> v == 0 }
            .map { (k, v) -> k }
            .toMutableList()
        var result = ""

        while (actionable.isNotEmpty()) {
            val next = actionable.removeAt(0)
            result += next

            for (child in children[next]!!) {
                degrees[child] = degrees[child]!! - 1
                if (degrees[child] == 0) actionable += child
            }
        }
        return result
    }
}
