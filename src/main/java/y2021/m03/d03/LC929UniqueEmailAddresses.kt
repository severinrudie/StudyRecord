package y2021.m03.d03

class LC929UniqueEmailAddresses {
    // O(n) time, O(k) space [where k is unique emails]
    fun numUniqueEmails(emails: Array<String>): Int {
        val set = mutableSetOf<String>()

        for (email in emails) {
            val split = email.split('@')
            var local = split[0]
                .filter { it != '.' }
                .takeWhile { it != '+' }
            val domain = split[1]
            set += "$local@$domain"
        }
        return set.size
    }
}