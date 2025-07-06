package array.leetcode

/**
 * 75. Sort Colors
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 */
/*
1. DEF
- Everytime int array
- Sort the ASC order
- Output sort the nums array

2. BOUNDARIES
- only contains 0, 1, 2
- can have only 1 num

3. TEST CASES
[2,0,2,1,1,0] -> [0,0,1,1,2,2]
[2,0,2,1,2,2] -> [0,1,2,2,2,2]
    - [0,2,2,1,2,2] -> [0,1,2,2,2,2]
    - [0,1,2,2,2,2] -> [0,1,2,2,2,2]
[0,0,0,1,2,1] ->

4. PSEUDO COE
    - loop through nums
        put to the map with counters

      var currentNum = 0
      loop through num:
         val value = map[currentNum] until count 0
         num[i] = value


 */
class SortColorsSolution {
    fun sortColors(nums: IntArray): Unit {
        val colorMap = HashMap<Int, Int>()
        var currentNum = 0
        var currentIndex = 0


        for (i in 0 until nums.size) {
            colorMap.put(nums[i], colorMap.getOrDefault(nums[i], 0) + 1)
        }

        while (currentIndex < nums.size) {
            val value = colorMap.getOrDefault(currentNum, 0)
            if (value > 0) {
                nums[currentIndex] = currentNum
                colorMap.put(currentNum, value - 1)
                currentIndex++
            } else {
                currentNum++
            }
        }

        println(nums.joinToString(","))
    }
}

/*
class Solution {
    fun sortColors(nums: IntArray): Unit {
        var l = 0
        var mid = 0
        var r = nums.size - 1
        while (mid <= r) {
            when (nums[mid]) {
                0 -> {
                    nums[l] = nums[mid].also { nums[mid] = nums[l] }
                    l++
                    mid++
                }

                1 -> {
                    mid++
                }

                2 -> {
                    nums[r] = nums[mid].also { nums[mid] = nums[r] }
                    r--
                }
            }
        }
    }
}
 */

fun main() {
    SortColorsSolution().sortColors(intArrayOf(2, 0, 2, 1, 1, 0))
}