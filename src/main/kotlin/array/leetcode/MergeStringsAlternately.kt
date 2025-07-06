package array.leetcode

/**
 * 1768. Merge Strings Alternately
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 *
 * Return the merged string.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 * Example 2:
 *
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 * Example 3:
 *
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 100
 * word1 and word2 consist of lowercase English letters.
 */
/*
1. DEF
    - two charsequence will be given
    - merge two string by one by if the any other is shorter than the other
    add longer one's remaining characters to the end
    - start with word1
    - return merged string

2. BOUNDARIES
    - word1, word2 string
    - return string

3. TEST CASES
    - "abcd", "efgh" -> "aebfgdh"
    - "ab", "cdef" -> "acbdef"
    - "abc", "ef" -> "aebfc"

4. PSEUDO CODE
    var mergedString = StringBuilder()
    loop through max(word1.len, word2.len):
        if (i < word1.len):
            mergedString.append(word1[i])

        if (i < word2.len)
            mergedString.append(word2[i])

     return mergedString

 */
class MergeStringsAlternatelySolution {
    fun mergeAlternately(word1: String, word2: String): String {
        val mergedString = StringBuilder()
        for (i in 0 until maxOf(word1.length, word2.length)) {
            if (i < word1.length) {
                mergedString.append(word1[i])
            }

            if (i < word2.length) {
                mergedString.append(word2[i])
            }
        }

        return mergedString.toString()
    }
}