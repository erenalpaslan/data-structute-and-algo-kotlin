package array.leetcode

/**
 * 26. Remove Duplicates from Sorted Array
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 *
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 *
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * Custom Judge:
 *
 * The judge will test your solution with the following code:
 *
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 *
 * int k = removeDuplicates(nums); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 */
/*
1. DEF
    - ASC sorted integer array given
    - return unique num count,
    - also nums should be sorted as well

2. BOUNDARIES
    - sorted integer array

3. TEST CASES
    - [0,0,1,1,1,2,2,3,3,4] -> [0,1,2,3,4,_,_,_,,,]
      [0,0,1,1,1,2,2,3,3,4] -> i = 0, j = 2
      [0,1,1,1,1,2,2,3,3,4] -> i = 1, j = 2
      [0,1,2,3,1,2,2,3,3,4] -> i = 2, j = 5

    - [1,1,2] -> [1,2,1]
        [1, 2, 2] -> i = 1, j = 2
     - [1,1] -> [1,1]
     - [1] -> [1]
     - [0,0,0,0,1]

4. PSEUDO CODE
    var slowIndex = 0
    var uniqueCount = 0
    loop through nums:
        if (nums[slowIndex] != nums[fastIndex]):
            nums[slowIndex + 1] = nums[fastIndex]
            slowIndex++
            uniqueCount++



 */
class RemoveDuplicatesFromSortedArraySolution {
    fun removeDuplicates(nums: IntArray): Int {
        var uniqueCount = 0
        var slowIndex = 0
        if (nums.size < 2) return 1

        for (i in 0 until nums.size) {
            if (nums[slowIndex] != nums[i]) {
                nums[slowIndex + 1] = nums[i]
                slowIndex++
                uniqueCount++
            }
        }

        println(nums.joinToString(","))
        return uniqueCount + 1
    }
}

fun main() {
    RemoveDuplicatesFromSortedArraySolution().removeDuplicates(intArrayOf(1,1,2))
}