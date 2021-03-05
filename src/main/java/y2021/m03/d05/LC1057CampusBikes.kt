package y2021.m03.d05

import java.util.*
import kotlin.math.abs

class LC1057CampusBikes {

    data class Pairing(val distance: Int, val bikeIndex: Int, val workerIndex: Int)

    // O(nm log nm) time, O(nm) space
    fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): IntArray {
        val queue = PriorityQueue<Pairing> { a, b ->
            when {
                a.distance != b.distance -> a.distance - b.distance
                a.workerIndex != b.workerIndex -> a.workerIndex - b.workerIndex
                else -> a.bikeIndex - b.bikeIndex
            }
        }

        for (wI in workers.indices) {
            for (bI in bikes.indices) {
                val worker = workers[wI]
                val bike = bikes[bI]
                val distance = abs(worker[0] - bike[0]) + abs(worker[1] - bike[1])
                queue += Pairing(distance, bikeIndex = bI, workerIndex = wI)
            }
        }

        val usedBikes = IntArray(bikes.size)
        val usedWorkers = IntArray(workers.size)
        var added = 0
        val result = IntArray(workers.size) { -1 }

        while (added < workers.size) {
            val next = queue.poll()
            if (usedBikes[next.bikeIndex] == 0 && usedWorkers[next.workerIndex] == 0) {
                usedBikes[next.bikeIndex] = 1
                usedWorkers[next.workerIndex] = 1
                added++
                result[next.workerIndex] = next.bikeIndex
            }
        }

        return result
    }
}