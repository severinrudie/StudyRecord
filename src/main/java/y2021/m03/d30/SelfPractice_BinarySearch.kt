package y2021.m03.d30

class SelfPractice_BinarySearch(private val list: List<Int>) {

    /**
     * Returns the index of any value that matches [target], or null if none.
     */
    fun any(target: Int): Int? {
        var l = 0
        var h = list.lastIndex

        while (l <= h) {
            val mid = (h - l) / 2 + l

            val num = list[mid]
            when {
                num == target -> return mid
                num < target -> l = mid + 1
                num > target -> h = mid - 1
            }
        }

        return null
    }

    /**
     * Returns the index of the first value that matches [target], or null if none.
     */
    fun first(target: Int): Int? {
        var l = 0
        var h = list.lastIndex
        var bestIndex: Int? = null

        while (l <= h) {
            val mid = (h - l) / 2 + l
            val num = list[mid]

            when {
                num == target -> {
                    bestIndex = mid
                    h = mid - 1
                }
                num < target -> l = mid + 1
                num > target -> h = mid - 1
            }
        }

        return bestIndex
    }

    /**
     * Returns the index of the last value that matches [target], or null if none.
     */
    fun last(target: Int): Int? {
        var l = 0
        var h = list.lastIndex
        var bestIndex: Int? = null

        while (l <= h) {
            val mid = (h - l) / 2 + l
            val num = list[mid]

            when {
                num == target -> {
                    bestIndex = mid
                    l = mid + 1
                }
                num < target -> l = mid + 1
                num > target -> h = mid - 1
            }
        }

        return bestIndex
    }

    /**
     * Returns the index of the last value smaller than [target], or null if none.
     */
    fun lastLessThan(target: Int): Int? {
        // Note: could also delegate to first, then take prev i
        var l = 0
        var h = list.lastIndex
        var leftMost: Int? = null

        while (l <= h) {
            val mid = (h - l) / 2 + l
            val num = list[mid]

            when {
                num == target -> {
                    leftMost = mid
                    h = mid - 1
                }
                num < target -> l = mid + 1
                num > target -> h = mid - 1
            }
        }

        return if (leftMost == null || leftMost == 0) null
            else leftMost - 1
    }

    /**
     * Returns the index of the first value greater than [target], or null if none.
     */
    fun firstGreaterThan(target: Int): Int? {
        // Note: could also delegate to last, then take next i
        var l = 0
        var h = list.lastIndex
        var rightMost: Int? = null

        while (l <= h) {
            val mid = (h - l) / 2 + l
            val num = list[mid]

            when {
                num == target -> {
                    rightMost = mid
                    l = mid + 1
                }
                num < target -> l = mid + 1
                num > target -> h = mid - 1
            }
        }
        return if (rightMost == null || rightMost == list.lastIndex) null
            else rightMost + 1
    }
}
