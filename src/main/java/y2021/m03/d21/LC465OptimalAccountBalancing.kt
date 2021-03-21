package y2021.m03.d21

import kotlin.math.min
import kotlin.math.sign

class LC465OptimalAccountBalancing {
    fun minTransfers(transactions: Array<IntArray>): Int {
        val debts = toDebts(transactions)
        return rec(debts)
    }

    fun toDebts(transactions: Array<IntArray>): MutableList<Int> {
        // person to balance
        val map = mutableMapOf<Int, Int>()
        for (t in transactions) {
            val from = t[0]
            val to = t[1]
            val amount = t[2]

            map[from] = (map[from] ?: 0) + amount
            map[to] = (map[to] ?: 0) - amount
        }
        return map.values.toMutableList()
    }

    fun rec(debts: MutableList<Int>): Int {

        var start = 0
        while (start <= debts.lastIndex && debts[start] != 0) {
            start++
        }
        if (start > debts.lastIndex) return 0

        val n1 = debts[start]
        var best = Int.MAX_VALUE

        for (i in start + 1..debts.lastIndex) {
            val n2 = debts[i]
            if (!diffSigns(n1, n2)) continue

            if (n1 + n2 == 0) {
                debts[start] = 0
                debts[i] = 0
                best = min(best, rec(debts))
                debts[start] = n1
                debts[i] = n2
            } else {
                debts[start] = n1 + n2
                debts[i] = 0
                best = min(best, rec(debts))
                debts[start] = n1
                debts[i] = n2
            }
        }
        return best
    }

    fun diffSigns(i1: Int, i2: Int): Boolean {
        return i1.sign != i2.sign &&
                (i1.sign == -1 || i2.sign == -1)
    }
}
