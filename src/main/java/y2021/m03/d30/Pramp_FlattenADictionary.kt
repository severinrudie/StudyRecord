package y2021.m03.d30

class Pramp_FlattenADictionary {
    // O(n) time, O(n) space
    fun flattenDictionary(input: Map<String, Any>): Map<String, String> {

        val result = mutableMapOf<String,String>()

        for ((k,v) in input) {
            if (v is String) {
                result[k] = v
            } else {
                // assume v is a map
                val v = v as Map<String,Object>

                val nestedResult = flattenDictionary(v)

                for ((nestedK, nestedV) in nestedResult) {
                    val newKey = if (nestedK.isNotEmpty()) "$k.$nestedK" else k
                    result[newKey] = nestedV
                }
            }
        }

        return result
    }
}
