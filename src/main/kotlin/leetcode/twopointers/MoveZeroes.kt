package leetcode.twopointers

/**
 * 283. Move Zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 */
/*

3. TEST CASES
    [0,1,0,3,12] -> [1,3,12,0,0]
        [1,0,0,3,12] -> l = 0, r = left + 1
        [1,0,0,3,12] -> l = 1, r = 2
        [1,3,0,0,12] -> l = 2, r = 3
        [1,3,0,0,12] -> l = 2, r = 4

    [1,1,0,3,12] -> [1,3,12,0,0]
        [1,1,0,3,12] -> l = 0, r = 1
        [1,1,0,3,12] -> l = 1, r = 2
        [1,1,0,3,12] -> l = 2, r = 3
        [1,1,3,0,12] -> l = 3, r = 4
        [1,1,0,0,12] -> l = 0, r = 1

    [1,1,0,0,0] -> l = 0, r = 1

4. PSEUDO CODE
    var left = 0
    var right = 1
    loop through nums while left < nums.size:
        if (nums[l] == 0):
            if (nums[right] > nums[l]):
                swap(nums, left, right)
                left++
                right = left + 1
            else
                right++
        else
            left++
            right = left + 1

 */
class MoveZeroesSolution {
    fun moveZeroes(nums: IntArray): Unit {
        var left = 0
        var right = 0
        while (left < nums.size) {
            if(nums[left] == 0) {
                if (nums[right] != 0) {
                    val temp = nums[right]
                    nums[right] = nums[left]
                    nums[left] = temp
                    left++
                    right = left + 1
                }else {
                    right++
                }
            }else {
                left++
                right = left + 1
            }


            if (right > nums.lastIndex) {
                left++
                right = left + 1
            }
        }
    }
}