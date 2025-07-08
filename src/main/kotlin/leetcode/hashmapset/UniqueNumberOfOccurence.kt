package leetcode.hashmapset

/**
 * 1207. Unique Number of Occurrences
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 *
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 *
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */
/*
1. DEF
    - Given an array with not ordered integers
    - count occurences and return true if all occurences is unique else false

2. BOUNDARIES
    - array can't be empty
    - not sorted

3. TEST CASES
    [1,1,1,1] -> true
    [1,2,3] -> false
    [1,1,2] -> true

4. PSEUDO CODE
    val occurenceHashMap = HashMap<Int, Int>()
    loop through arr:
        occurenceHashMap put arr[i] to count

    hashMap.valueSet.size == hashMap.size

 */
class UniqueNumberOfOccurenceSolution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val occurenceHashMap = HashMap<Int, Int>()
        arr.forEach {
            occurenceHashMap.put(it, occurenceHashMap.getOrDefault(it, 0) + 1)
        }

        return occurenceHashMap.values.toHashSet().size == occurenceHashMap.size
    }
}