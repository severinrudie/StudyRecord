package y2021.m03.d21

import java.util.*

class LC315CountOfSmallerNumbersAfterSelf {
    val vals = mutableListOf<Int>()

    fun countSmaller(nums: IntArray): List<Int> {

        val result = IntArray(nums.size)
        for (i in nums.indices.reversed()) {
            val num = nums[i]
            var insert = vals.binarySearch(num)
            if (insert < 0) insert = -insert - 1
            while (insert > 0 && vals[insert - 1] == num) insert--
            vals.add(insert, num)
            result[i] = insert
        }

        return result.toList()
    }
}
