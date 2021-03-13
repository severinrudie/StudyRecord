package y2021.m03.d12

class LC734SentenceSimilarity {
    fun areSentencesSimilar(
        sentence1: Array<String>,
        sentence2: Array<String>,
        similarPairs: List<List<String>>
    ): Boolean {
        if (sentence1.size != sentence2.size) return false
        val similarities = mutableMapOf<String, List<String>>()

        for (pair in similarPairs) {
            val first = pair[0]
            val second = pair[1]
            similarities[first] = (similarities[first] ?: emptyList()) + second
            similarities[second] = (similarities[second] ?: emptyList()) + first
        }

        for (i in sentence1.indices) {
            val a = sentence1[i]
            val b = sentence2[i]

            if (a != b && !(similarities[a] ?: emptyList()).contains(b)) return false
        }
        return true
    }
}