package leetcode.prefixsum

/**
 * 724. Find Pivot Index
 * Given an array of integers nums, calculate the pivot index of this array.
 *
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
 *
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
 *
 * Return the leftmost pivot index. If no such index exists, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * Explanation:
 * The pivot index is 3.
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 * Example 3:
 *
 * Input: nums = [2,1,-1]
 * Output: 0
 * Explanation:
 * The pivot index is 0.
 * Left sum = 0 (no elements to the left of index 0)
 * Right sum = nums[1] + nums[2] = 1 + -1 = 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 */
/*
1. DEF
    - Find pivot index
    - an array will be given
    - If there is no pivot return -1
    - else return leftmost pivot index
    - array can't be empty

2. BOUNDARIES
    - integer array will be given
    - return integer
    - array can't be empty

3. TEST CASES
    [1,1,1,1] -> -1
    [1,7,3,6,5,6] -> 3 (6)
    [1,2,3] -> -1
    [2,1,-1] -> 0
    [1] -> 0
    [1,0] -> 0

4. PSEUDO CODE
    pivotIndex = -1
    loop through nums:
        sum left subarray
        sum right subarray
        if left == right:
            pivotIndex = i
            break

    return pivotIndex

 */
class FindPivotIndexSolution {
    fun pivotIndex(nums: IntArray): Int {
        var pivotIndex = -1
        for (i in 0 until nums.size) {
            var leftTotal = if (i == 0) {
                0
            }else {
                sumSubArray(nums, 0, maxOf(i - 1, 0))
            }
            var rightTotal = if (i == nums.lastIndex) {
                0
            }else {
                sumSubArray(nums, minOf(i + 1, nums.lastIndex), nums.lastIndex)
            }
            if (leftTotal == rightTotal) {
                pivotIndex = i
                break
            }
        }

        return pivotIndex
    }

    fun sumSubArray(nums: IntArray, startIndex: Int, endIndex: Int): Int {
        return nums.slice(startIndex .. endIndex).sum()
    }
}

fun main() {
    FindPivotIndexSolution().pivotIndex(intArrayOf(1,2,3))
}