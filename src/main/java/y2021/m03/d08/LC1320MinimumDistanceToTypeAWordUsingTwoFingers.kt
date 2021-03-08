package y2021.m03.d08

import kotlin.math.abs

// TODO this overflows the stack on a 5 letter word.  Needs to handle 500
// TODO also WAY too much code
class LC1320MinimumDistanceToTypeAWordUsingTwoFingers {
    data class Coord(val row: Int, val col: Int)

    fun minimumDistance(word: String): Int {
        if (word.length <= 2) return 0
        val coords = word.map { it.toCoord() }
        val (a, b) = getExtremes(coords)
        val (clusterA, clusterB) = divideInto(coords, a, b)
        val adjListA = buildAdjList(clusterA)
        val adjListB = buildAdjList(clusterB)

        return shortestPath(clusterA, adjListA).second + shortestPath(clusterB, adjListB).second
    }

    fun buildAdjList(cluster: List<Coord>): Array<IntArray> {
        // TODO dont build duplicates in adj list
        val adjList = Array(cluster.size) { IntArray(cluster.size) }

        for (i in cluster.indices) {
            for (j in i + 1..cluster.lastIndex) {
                val dist = getDistance(cluster[i], cluster[j])
                adjList[i][j] = dist.toInt()
                adjList[j][i] = dist.toInt()
            }
        }
        return adjList
    }

    // O(n!) TODO gotta find a better way to do this
    fun shortestPath(
        cluster: List<Coord>,
        adjList: Array<IntArray>,
        withoutIndexes: Set<Int> = emptySet(),
        total: Int = 0,
        prevIndex: Int? = null
    ): Pair<Coord?, Int> {
        if (cluster.size <= 1) return cluster.firstOrNull() to 0
        if (withoutIndexes.size == cluster.size - 1) {
            for (i in cluster.indices) {
                if (i !in withoutIndexes) return cluster[i] to total + adjList[i][prevIndex!!]
            }
        }

        var minDist = Int.MAX_VALUE
        var bestCoord: Coord? = null
        for (i in cluster.indices) {
            val newTotal = if (prevIndex == null) 0 else adjList[i][prevIndex]
            val newShort = shortestPath(
                cluster,
                adjList,
                withoutIndexes + i,
                newTotal,
                i
            ).second
            if (newShort < minDist) {
                minDist = newShort
                bestCoord = cluster[i]
            }
        }
        return bestCoord!! to minDist
    }

    fun Char.toCoord(): Coord {
        val num = this.toInt() - 'A'.toInt()
        val row = num / 6
        val col = num % 6
        return Coord(row = row, col = col)
    }

    fun getExtremes(coords: List<Coord>): Pair<Coord, Coord> {
        val grav = centerOfGravity(coords)
        val furthest = furthestFrom(grav, coords)
        val other = furthestFrom(furthest, coords)
        return furthest to other
    }

    fun divideInto(coords: List<Coord>, a: Coord, b: Coord): Pair<List<Coord>, List<Coord>> {
        val aCluster = mutableListOf<Coord>()
        val bCluster = mutableListOf<Coord>()
        coords.map { it to (getDistance(it, a) to getDistance(it, b)) }
            .forEach { (coord, distances) ->
                val (distA, distB) = distances
                if (distA > distB) aCluster += coord
                else bCluster += coord
            }
        return aCluster to bCluster
    }

    fun centerOfGravity(coords: List<Coord>): Coord {
        val rowAvg = coords.map { it.row }.average()
        val colAvg = coords.map { it.col }.average()
        return Coord(row = rowAvg.toInt(), col = colAvg.toInt())
    }

    fun furthestFrom(from: Coord, all: List<Coord>): Coord {
        return all.map { it to getDistance(from, it) }.maxBy { it.second }!!.first
    }

    fun getDistance(a: Coord, b: Coord): Double {
        return abs((a.row.toDouble() - b.row.toDouble())) + abs((a.col.toDouble() - b.col.toDouble()))
    }
}
