package y2021.m02.d02

class EDU_12_C1_FlipAndInvertImage {

    // O(n) time, O(1) space
    fun flipAndInvertImage(arr: Array<Array<Int>>): Array<Array<Int>> {
        val width = arr[0].size

        for (row in arr) {
            for (i in 0 until (width / 2)) {
                val temp = row[i]
                row[i] = row[row.lastIndex - i] xor 1
                row[row.lastIndex - i] = temp xor 1
            }
            if (width % 2 == 1) {
                val mid = width / 2 + 1
                row[mid] = row[mid] xor 1
            }
        }

        return arr
    }

}