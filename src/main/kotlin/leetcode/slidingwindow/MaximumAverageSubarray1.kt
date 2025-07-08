package leetcode.slidingwindow

/**
 * 643. Maximum Average Subarray I
 * You are given an integer array nums consisting of n elements, and an integer k.
 *
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * Example 2:
 *
 * Input: nums = [5], k = 1
 * Output: 5.00000
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 104
 */
/*
1. DEF
    - Given an array, and k number
    - k number is for subarray length
    - is this sorted => No
    - return maximum average
    - find the contiguous subarray and get the average

2. BOUNDARIES
    - nums is an intarray
    - k is an int
    - not null
    - not empty array
    - 1 <= k
    - k can't be bigger than nums.size

3. TEST CASES
    [1,12,-5,-6,50,3], k = 4 => (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
    [1], k = 1 => 1
    [0], k = 1 => 0
    [-1, -2, -3, -4, 0], k = 2 => -1, 0 / -1/2 = -0.5
    [1, 2, 3, 0, 5] -> k = 2 => 5 / 2 => 2.5
        [1, 2, 3, 0, 5] => l=0, r=0, totalCount=0
        [1, 2, 3, 0, 5] => l=0, r=2, totalCount=3
        [1, 2, 3, 0, 5] => l=1, r=1, totalCount=0, max = 1.5

    [-1,-1,-2], k=2 => -1


4. PSEUDO CODE
    var left = 0
    var right = 0
    var maximumAverageCount: Double = 0
    var totalCount = 0
    loop though nums while left < nums.size - k:
        totalCount += nums[right]
        right++
        if right == k:
            val newAverage = totalCount / k
            if (newAverage < 0 && maximumAverageCount == 0) {
                maximumAverageCount = newAverage
            else if (maximumAverageCount < newAverage):
                maximumAverageCount = newAverage
            totalCount = 0
            left++
            right = left

    return maximumAverageCount

 */
class MaximumAverageSubarray1Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var left = 0
        var right = 0
        var maximumAverageCount = 0.0
        var totalCount = 0.0
        while (left <= nums.size - k) {
            totalCount += nums[right]
            right++

            if (right == k + left) {
                val newAverage = totalCount / k
                if (maximumAverageCount < newAverage || (maximumAverageCount == 0.0 && newAverage < 0.0)) {
                    maximumAverageCount = newAverage
                }
                totalCount = 0.0
                left++
                right = left
            }
        }

        return maximumAverageCount
    }
}