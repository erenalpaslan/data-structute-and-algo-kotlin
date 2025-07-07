package leetcode.twopointers

/**
 * 392. Is Subsequence
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 *
 */
/*
3. TEST CASES
    "abc", "acbbgdc"
    "b", "c"

4. PSEUDO CODE
    var subSequenceIndex = 0
    if s.len > t.len: return false

    loop through t:
        if t[i] == s[subSequenceIndex]:
            subSequenceIndex++
            if (subSequenceIndex > s.lastIndex):
                break

    return subSequence - 1 == s.lastIndex

 */
class IsSubsequenceSolution {
    fun isSubsequence(s: String, t: String): Boolean {
        var subSequenceIndex = 0
        when {
            s.isEmpty() && t.isNotEmpty() || s.isEmpty() && t.isEmpty() -> return true
            s.length > t.length || t.isEmpty() -> return false
        }

        for(i in 0 until t.length) {
            if(t[i] == s[subSequenceIndex]) {
                subSequenceIndex++
                if(subSequenceIndex > s.lastIndex) {
                    break
                }
            }
        }

        return subSequenceIndex == s.length
    }
}