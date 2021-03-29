package y2021.m03.d29

class Pramp_ArrayOfArrayProducts {
    // O(n) time, O(n)
    fun arrayOfArrayProducts(arr: IntArray): IntArray {
        val prodLeft = IntArray(arr.size) { 1 }
        val prodRight = IntArray(arr.size) { 1 }

        for (i in arr.indices) {
            val prev = if (i == 0) 1 else prodLeft[i - 1]
            prodLeft[i] = prev * arr[i]
        }
        for (i in arr.indices.reversed()) {
            val prev = if (i == arr.lastIndex) 1 else prodRight[i + 1]
            prodRight[i] = prev * arr[i]
        }

        val result = IntArray(arr.size)
        for (i in arr.indices) {
            val toLeft = if (i == 0) 1 else prodLeft[i - 1]
            val toRight = if (i == arr.lastIndex) 1 else prodRight[i + 1]
            result[i] = toLeft * toRight
        }
        return result
    }

    // O(n^2) time, O(n) space
    fun bruteForce_arrayOfArrayProducts(arr: IntArray): IntArray {
        val result = IntArray(arr.size) { 1 }

        for (i in arr.indices) {
            for (j in arr.indices) {
                if (i == j) continue
                result[i] *= arr[j]
            }
        }
        return result
    }
}