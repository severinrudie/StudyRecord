package y2021.m03.d26

class LC1376TimeNeededToInformAllEmployees {
    fun numOfMinutes(n: Int, headID: Int, managers: IntArray, informTimes: IntArray): Int {
        // build subordinates HM
        // recursively call each subordinate to find max path time
        // leaf nodes have weight 0
        // return max

        val subordinates = mutableMapOf<Int, List<Int>>()

        for (i in managers.indices) {
            if (i == headID) continue
            val sub = i
            val boss = managers[i]

            subordinates[boss] = (subordinates[boss] ?: emptyList()) + sub
        }

        return findMax(headID, subordinates, informTimes)
    }

    fun findMax(manager: Int, subordinates: Map<Int, List<Int>>, informTimes: IntArray): Int {
        // leafs have no one to inform
        val employees = subordinates[manager] ?: return 0

        val maxDescendent = employees.map { findMax(it, subordinates, informTimes) }.max()!!

        return informTimes[manager] + maxDescendent
    }
}