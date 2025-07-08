package leetcode.hashmapset

/**
 * 2215. Find the Difference of Two Arrays
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 *
 * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 * Note that the integers in the lists may be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3], nums2 = [2,4,6]
 * Output: [[1,3],[4,6]]
 * Explanation:
 * For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
 * For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums1. Therefore, answer[1] = [4,6].
 * Example 2:
 *
 * Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
 * Output: [[3],[]]
 * Explanation:
 * For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
 * Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * -1000 <= nums1[i], nums2[i] <= 1000
 */
/*
1. DEF
    - two array will be given nums1, nums2
    - return list of two listOf(listOfAllDistinctIntegersNums1, listOfAllDistinctIntegersNums2)
    - lists not ordered
    - if nums1 == nums2 return listOf(emptyList, emptyList)

2. BOUNDARIES
    - nums1, nums2 are intArray
    - return List<List<Int>>
    - list[0] = nums1 distinct numbers
    - list[1] = nums2 distinct numbers
    - list length >= 1, can't be empty

4. TEST CASES
    - [1,2,3], [4,5,1] -> [[2,3], [4,5]]
        [1,2,3], [4,5,1] -> hashMap 1-false, 2->true, 3->true |  listOf(4,5)
    - [1,1], [1] -> [[], []]
    - [1,1], [2,3] -> [[1], [2,3]]

5. PSEUDO CODE
    val uniqueList2 = HashSet<Int>()
    val nums1Set = nums1.toHashSet()
    loop through nums2:
        if (nums1Set.contains nums2[i]):
            nums1Set.remove(nums2[i])
        else
            uniqueList2.add(nums2)


 */
class FindTheDifferenceOfTwoArraysSolution {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val nums1Set = nums1.toHashSet()
        val nums2Set = nums2.toHashSet()
        nums2.forEach {
            if (nums1Set.contains(it)) {
                nums1Set.remove(it)
            }
        }
        nums1.forEach {
            if (nums2Set.contains(it)) {
                nums2Set.remove(it)
            }
        }
        return listOf(nums1Set.toList(), nums2Set.toList())
    }
}