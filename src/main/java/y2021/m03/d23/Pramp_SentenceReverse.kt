package y2021.m03.d23

class Pramp_SentenceReverse {

/*
You are given an array of characters arr that consists of sequences of characters separated by space characters. Each space-delimited sequence of characters defines a word.

Implement a function reverseWords that reverses the order of the words in the array in the most efficient manner.

Explain your solution and analyze its time and space complexities.

Example:

input:  arr = [ 'p', 'e', 'r', 'f', 'e', 'c', 't', '  ',
                'm', 'a', 'k', 'e', 's', '  ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]

output: [ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', '  ',
          'm', 'a', 'k', 'e', 's', '  ',
          'p', 'e', 'r', 'f', 'e', 'c', 't' ]

 */

    // O(n) time, O(1) space
    fun reverseWords(arr: CharArray): CharArray {
        fun swap(i: Int, j: Int) {
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }


        for (i in 0 until arr.size / 2) {
            swap(i, arr.lastIndex - i)
        }

        var lastSpace = -1 // -1
        var nextSpace = -1 // 3

        while (nextSpace == arr.size) {
            lastSpace = nextSpace
            nextSpace++
            while (nextSpace <= arr.lastIndex && arr[nextSpace] != ' ') nextSpace++

            val c1 = lastSpace + 1 // 0
            val c2 = nextSpace - 1 // 2
            val midWay = (c2 - c1) / 2 + c1

            // swap the word
            for (i in c1 until midWay) {
                swap(i, c2 - i)
            }
        }
        return arr
    }
}
