package y2021.m03.d28

class IK_CoinCombinations {

    // O(nk) time, O(k) space [where k == target]
    fun coins(
        coins: List<Int>,
        target: Int
    ): Int {
        val buckets = IntArray(target + 1) { 0 }
        buckets[0] = 1

        for (i in 1..target) { // 3
            val checked = mutableSetOf<Int>() // 2
            for (coin in coins) { // 2
                if (coin in checked) continue
                val prev = i - coin
                if (prev < 0) continue
                checked += prev
                buckets[i] += buckets[prev]
            }
        }
        return buckets[target]
    }
}