package y2021.m02.d03

import java.util.*

class EDU_13_6_FrequencySort {

    // O(n log d) time [where d is the number of distinct chars in the string], O(n) space
    fun sortCharacterByFrequency(str: String): String {
        val counts = str.groupBy { it }
            .map { entry -> entry.key to entry.value.size }

        val maxHeap = PriorityQueue<Pair<Char, Int>> { a,b -> b.second - a.second }

        for (count in counts) {
            maxHeap.offer(count)
        }

        val result = StringBuilder()
        while (maxHeap.isNotEmpty()) {
            val entry = maxHeap.poll()
            result.append(entry.first.toString().repeat(entry.second))
        }

        return result.toString()
    }
}