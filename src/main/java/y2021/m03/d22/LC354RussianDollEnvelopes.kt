package y2021.m03.d22

import kotlin.math.max

class LC354RussianDollEnvelopes {
    // O(n ^ 2) time [memoized], O(n) space
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        if (envelopes.isEmpty()) return 0

        val envelopes = envelopes.sortedBy { it.first() }
        val mem = mutableMapOf<Int, Int>()
        var best = 0
        for (i in envelopes.indices.reversed()) {
            best = max(best, fit(i, envelopes, mem))
        }
        return best
    }

    fun fit(curr: Int, envs: List<IntArray>, mem: MutableMap<Int,Int>): Int {
        if (mem.contains(curr)) return mem[curr]!!

        var max = 0

        for (i in curr + 1..envs.lastIndex) {
            if (envs[curr][0] < envs[i][0] && envs[curr][1] < envs[i][1]) {
                max = max(max, fit(i, envs, mem))
            }
        }

        val total = max + 1
        mem[curr] = total
        return total
    }
}
