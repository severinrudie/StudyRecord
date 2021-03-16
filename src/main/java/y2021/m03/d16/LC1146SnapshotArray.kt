package y2021.m03.d16

class LC1146SnapshotArray {
    class SnapshotArray(length: Int) {

        // $1 was affected by changes[$2]
        val affectedBy = mutableMapOf<Int, List<Int>>()
        // changes[i].each == $1 set to $2
        val changes = mutableListOf<Map<Int, Int>>()
        // $1 set to $2
        var currChanges = mutableMapOf<Int,Int>()

        // O(1) time
        fun set(index: Int, num: Int) {
            currChanges[index] = num
        }

        // O(currChanges.size) time
        fun snap(): Int {
            changes += currChanges
            currChanges.forEach { (index, newVal) ->
                affectedBy[index] = (affectedBy[index] ?: emptyList()) + changes.lastIndex
            }
            // clear curr
            currChanges = mutableMapOf()

            return changes.size - 1
        }

        // O(prevSnap.size) time
        fun get(index: Int, snapId: Int): Int {
            val prevSnap = affectedBy[index]?.lastOrNull { it <= snapId } ?: return 0
            return changes[prevSnap][index] ?: 0
        }
    }
}