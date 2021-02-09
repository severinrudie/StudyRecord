package y2021.m02.d08

import java.util.*

class EDU_14_C1_KPairsWithLargestSums {

    // O(n m log k) time, O(k) space [where n is nums1 and m is nums2]
    fun findKLargestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<Pair<Int,Int>> {
        // min heap
        val maxPairs = PriorityQueue<Pair<Int,Int>> { a,b -> (a.first + a.second) - (b.first + b.second) }

        for (num1 in nums1) {
            for (num2 in nums2) {
                if (maxPairs.size < k) {
                    maxPairs.offer(num1 to num2)
                    continue
                }
                if (maxPairs.peek().let { it.first + it.second } > num1 + num2) break

                maxPairs.poll()
                maxPairs.offer(num1 to num2)
            }
        }
        return maxPairs.toList()
    }
}
