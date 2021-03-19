package y2021.m03.d19

/*
Output formula permutations with operators, all input integers are positive and no duplicate

input: [1,2]
output: ['1+2','2+1','1-2','2-1','1*2','2*1','1/2','2/1']

input: [1,2,3]
output: ['1+2+3', '1-2-3', '1*2/3', '1/2*3', '2+1+3', '2-1*3', '2*1/3', '2/1+3'.......];

NOTE:

operators can duplicate within a formula string
operators are + - * / only
no time complexity requirement or concerns
*/
class BuildPermutationsWithOperators {
    fun buildPermutations(nums: List<Int>, stem: String = ""): List<String> {
        if (nums.isEmpty()) return listOf(stem)
        val nextIsDigit = stem.isEmpty() || stem.lastOrNull() !in '0'..'9' // false

        val candidates = if (nextIsDigit) nums.map { it.toString() } else listOf('+','-','/','*') // '+','-','/','*'

        val result = mutableListOf<String>()
        for (i in candidates.indices) {
            val next = candidates[i]

            val newNums = if (nextIsDigit) nums.filterIndexed { index, v -> i != index  } else nums
            result += buildPermutations(newNums, stem + next)
        }

        return result
    }
}
