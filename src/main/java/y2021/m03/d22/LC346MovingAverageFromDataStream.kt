package y2021.m03.d22

import java.util.*

class LC346MovingAverageFromDataStream {
    class MovingAverage(val size: Int) {

        /** Initialize your data structure here. */

        val ll = LinkedList<Int>()
        var sum = 0

        fun next(num: Int): Double {
            ll.addFirst(num)
            sum += num
            if (ll.size > size) {
                val removed = ll.removeLast()
                sum -= removed
            }

            return sum.toDouble() / ll.size
        }
    }
}
