package y2021.m03.d08

import java.util.*

class LC602TopKFrequentWords {
    // O(n log k) time, O(n) space
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val counted = words.groupingBy { it }.eachCount()

        val maxHeap = PriorityQueue<Pair<String, Int>> { a, b ->
            if (a.second != b.second) a.second - b.second
            else {
                b.first.compareTo(a.first)
            }
        }

        for ((word, count) in counted) {
            maxHeap.offer(word to count)
            if (maxHeap.size > k) maxHeap.poll()
        }

        val backwards = mutableListOf<String>()
        while (maxHeap.isNotEmpty()) {
            backwards += maxHeap.poll().first
        }

        return backwards.reversed()
    }
}