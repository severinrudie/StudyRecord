package y2021.m03.d07

import java.util.*

class LC947MostStonesRemovedWithSameRowOrColumn {
    fun removeStones(stones: Array<IntArray>): Int {
        val x = mutableMapOf<Int, MutableList<Int>>()
        val y = mutableMapOf<Int, MutableList<Int>>()

        for (i in 0..stones.lastIndex) {
            val stone = stones[i]
            x[stone[0]] = ((x[stone[0]] ?: mutableListOf()) + i).toMutableList()
            y[stone[1]] = ((y[stone[1]] ?: mutableListOf()) + i).toMutableList()
        }
        x[stones[0][0]]!!.remove(0)
        y[stones[0][1]]!!.remove(0)

        val following = LinkedList<Int>()
        val unvisited = (1 until stones.size).toMutableList()
        following.addFirst(0)
        var groups = 0

        while (following.isNotEmpty()) {
            while (following.isNotEmpty()) {
                val nextI = following.removeFirst() //0
                val next = stones[nextI] // 0,0

                val adding = mutableListOf<Int>()
                adding.addAll(x[next[0]]!!)
                adding.addAll(y[next[1]]!!)

                unvisited.removeAll(adding)
                following.addAll(adding)
                adding.forEach { i ->
                    val stone = stones[i]
                    x[stone[0]]!!.remove(i)
                    y[stone[1]]!!.remove(i)
                }
            }
            groups++
            if (unvisited.isNotEmpty()) following += unvisited.removeAt(0)
        }

        return stones.size - groups
    }
}