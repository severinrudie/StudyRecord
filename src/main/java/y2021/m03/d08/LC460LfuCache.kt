package y2021.m03.d08

import java.util.*

class LC460LfuCache(private val capacity: Int) {

    private var time = 0

    private data class Entry(val key: Int, val value: Int, val frequency: Int, val usedAtTime: Int)

    private val map = mutableMapOf<Int, Entry>()
    private val worstFrequencies = PriorityQueue<Entry> { a, b ->
        if (a.frequency != b.frequency) a.frequency - b.frequency
        else a.usedAtTime - b.usedAtTime
    }

    // O(logn) time, O(1) space
    fun get(key: Int): Int {
        val entry = map[key]
        if (entry == null) return -1

        val newCopy = entry.copy(frequency = entry.frequency + 1, usedAtTime = time)
        time++

        worstFrequencies.remove(entry) // logn
        worstFrequencies.offer(newCopy) //logn
        map[key] = newCopy //1

        return entry.value
    }

    // O(logn) time, O(n) space
    fun put(key: Int, value: Int) {
        if (capacity == 0) return
        val entry = map[key] ?: Entry(key = key, value = value, frequency = 0, usedAtTime = -1)
        val updatedEntry = entry.copy(value = value, frequency = entry.frequency + 1, usedAtTime = time)
        time++

        if (worstFrequencies.size == capacity && !map.containsKey(key)) {
            val remove = worstFrequencies.poll()
            map.remove(remove.key)
        }

        if (map[key] != null) worstFrequencies.remove(entry) //logn
        worstFrequencies.add(updatedEntry) // logn
        map[key] = updatedEntry //1
    }
}
