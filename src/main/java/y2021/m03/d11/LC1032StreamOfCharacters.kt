package y2021.m03.d11

class LC1032StreamOfCharacters

enum class Match {
    PARTIAL, FULL, NONE
}

class StreamChecker(words: Array<String>) {

    val trie = ReverseTrie(words)

    val longest = words.map { it.length }.max()!!
    val prevChars = mutableListOf<Char>()

    fun query(letter: Char): Boolean {
        prevChars.add(letter)
        if (prevChars.size > longest) prevChars.removeAt(0)

        for (i in prevChars.lastIndex downTo 0) {
            val result = trie.matches(prevChars.subList(i, prevChars.size))
            if (result == Match.FULL) return true
            else if (result == Match.NONE) return false
        }
        return false
    }
}

class ReverseTrie(words: Array<String>) {

    private class Node(var fullWord: Boolean = false, val children: Array<Node?> = Array(27) { null })

    private val root = Node()

    init {
        for (word in words) {
            if (word.isEmpty()) continue
            var lastLevel = root
            for (i in word.lastIndex downTo 0) {
                val cNum = word[i].toIndex()
                if (lastLevel.children[cNum] == null) lastLevel.children[cNum] = Node()
                if (i == 0) lastLevel.children[cNum]!!.fullWord = true
                lastLevel = lastLevel.children[cNum]!!
            }
        }
    }

    fun matches(word: List<Char>): Match {
        var lastLevel = root
        for (i in word.lastIndex downTo 0) {
            val c = word[i]
            val next = lastLevel.children[c.toIndex()]
            if (next == null) return Match.NONE
            lastLevel = next
        }
        return if (lastLevel.fullWord) Match.FULL
        else Match.PARTIAL
    }

    private fun Char.toIndex(): Int = (this - 'a').toInt()
}