package y2021.m02.d03

import java.util.*

class EDU_13_8_KClosestNumbers {

    // O(n log k) time, O(k) space // There's a more efficient algo: BS to closest num, two pointer outwards
    fun findClosestElements(arr: IntArray, outputSize: Int, target: Int): List<Int> {
        val below = PriorityQueue<Int>() // min
        val above = PriorityQueue<Int>(Comparator.reverseOrder()) // max

        for (num in arr) {
            if (below.size + above.size < outputSize) {
                if (num <= target) below.offer(num)
                else above.offer(num)
            } else {
                if (num <= target && (below.size == 0 || below.peek() < num)) {
                    below.poll()
                    below.add(num)
                } else if (num > target && (above.size == 0 || above.peek() > num)) {
                    above.poll()
                    above.add(num)
                }
                // rebalance
                if (above.size + below.size > outputSize) {
                    if (above.peek() - target > target - below.peek()) above.poll()
                    else below.poll()
                }
            }
        }
        return above.toList() + below.toList()
    }
}
