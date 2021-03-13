package y2021.m03.d12

class LC737SentenceSimilarity2 {
    // Done in a rush during a mock interview.  Not super efficient
    fun areSentencesSimilarTwo(
        words1: Array<String>,
        words2: Array<String>,
        pairs: List<List<String>>
    ): Boolean {
        if (words1.size != words2.size) return false

        val map = mutableMapOf<String, List<String>>()
        for (pair in pairs) {
            val first = pair[0]
            val second = pair[1]
            map[first] = (map[first] ?: emptyList()) + second
            map[second] = (map[second] ?: emptyList()) + first
        }

        val clusterList = toClusters(map)
        // println(clusterList)

        // build pairs into graph
        // break pairs into clusters
        // end up with List<Set<String>>
        // check that both A and B are found in the same set

        for (i in words1.indices) {
            val first = words1[i]
            val second = words2[i]

            if (first == second) continue
            if (clusterList.none { it.contains(first) && it.contains(second) }) {
                return false
            }
        }

        return true
    }

    fun toClusters(map: Map<String, List<String>>): List<Set<String>> {
        val clusters = mutableListOf<MutableSet<String>>()

        for ((key, matches) in map) {
            val clusterMatches = clusters.filter { it.contains(key) } ?: emptyList()
            val newCluster = clusterMatches.flatMap { it }.toMutableSet()

            newCluster.addAll(matches)

            clusterMatches.forEach { clusters -= it }
            clusters += newCluster
        }

        return clusters
    }
}