package y2021.m03.d18

class LC721AccountsMerge {
    // O(n) time, O(n) space
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {

        val reps = mutableMapOf<String, String?>()
        val names = mutableMapOf<String, String>()

        fun getParent(str: String): String {
            var rep = reps[str] ?: str
            while (reps[rep] != null) rep = reps[rep]!!
            return rep
        }

        for (account in accounts) {
            val name = account[0]
            val emails = account.subList(1, account.size)
            val groupRep = getParent(emails.first())
            for (email in emails) {
                names[email] = name
                val parentRep = getParent(email)
                if (parentRep != groupRep) reps[parentRep] = groupRep
            }
            reps[groupRep] = null
        }
        var i = 0
        val setNums = reps.filter { (k,v) -> v == null }.map { (k,v) -> k to i++ }.toMap()

        val disjointSets = List(setNums.size) { mutableSetOf<String>() }
        reps.forEach { k,v ->
            val bucket = setNums[getParent(k)]!!
            disjointSets[bucket] += k
        }

        return disjointSets.map { listOf(names[it.first()]!!) + it.sorted() }
    }
}