package y2021.m03.d04

// class construction: O(n) time, O(n) space
// isUnique calls: O(1) time, O(1) space
class LC288UniqueWordAbbreviation(dictionary: Array<String>) {

    val set = dictionary.toSet()
    val map = set
        .map { it.toAbb() }
        .groupingBy { it }
        .eachCount()

    fun isUnique(word: String): Boolean {
        val target = if (word in set) 1 else 0
        return (map[word.toAbb()] ?: 0) == target
    }

    private fun String.toAbb(): String = if (length <= 2) this
            else "${first()}${length - 2}${last()}"
}
