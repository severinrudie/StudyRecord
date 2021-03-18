package y2021.m03.d18

import kotlin.math.abs

class LC1048LongestStringChain {
    // O(n ^ 2) time, O(n) space
    fun longestStrChain(words: Array<String>): Int {
        // graph
        // connect each node to every node with 1 addition
        // topo sort

        val children = mutableMapOf<String, List<String>>()
        val parentCount = mutableMapOf<String, Int>()

        for (word in words) {
            children[word] = emptyList()
            parentCount[word] = 0
        }

        for (i in words.indices) {
            // map of char to count
            for (j in i + 1..words.lastIndex) {
                if (i == j) continue
                val iLen = words[i].length
                val jLen = words[j].length
                if (abs(iLen - jLen) != 1) continue

                val (small, big) = if (iLen < jLen) words[i] to words[j]
                else words[j] to words[i]

                var skipped = false
                var valid = true

                var j = 0
                for (i in big.indices) {
                    if (j > small.lastIndex || big[i] != small[j]) {
                        if (skipped) {
                            valid = false
                            break
                        } else {
                            skipped = true
                        }
                    } else {
                        j++
                    }
                }

                if (skipped && valid) {
                    // valid edge
                    children[small] = children[small]!!+ big
                    parentCount[big] = parentCount[big]!! + 1
                }
            }
        }

        // init to sources
        var processing = parentCount.filter { (k,v) -> v == 0 }
            .map { (k,v) -> k }
            .toMutableList()

        var longest = 0
        while (processing.isNotEmpty()) {
            longest++
            val peers = processing
            processing = mutableListOf<String>()

            for (peer in peers) {
                for (child in children[peer]!!) {
                    parentCount[child] = parentCount[child]!! - 1
                    if (parentCount[child] == 0) processing.add(child)
                }
            }
        }

        return longest
    }
}
