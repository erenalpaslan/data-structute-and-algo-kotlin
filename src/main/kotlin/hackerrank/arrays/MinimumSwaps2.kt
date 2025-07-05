package hackerrank.arrays

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/**
 * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements. Find the minimum number of swaps required to sort the array in ascending order.
 *
 * Example
 *
 *
 * Perform the following steps:
 *
 * i   arr                         swap (indices)
 * 0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
 * 1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
 * 2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
 * 3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
 * 4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
 * 5   [1, 2, 3, 4, 5, 6, 7]
 * It took  swaps to sort the array.
 *
 * Function Description
 *
 * Complete the function minimumSwaps in the editor below.
 *
 * minimumSwaps has the following parameter(s):
 *
 * int arr[n]: an unordered array of integers
 * Returns
 *
 * int: the minimum number of swaps to sort the array
 * Input Format
 *
 * The first line contains an integer, , the size of .
 * The second line contains  space-separated integers .
 *
 * Constraints
 *
 * Sample Input 0
 *
 * 4
 * 4 3 1 2
 * Sample Output 0
 *
 * 3
 * Explanation 0
 *
 * Given array
 * After swapping  we get
 * After swapping  we get
 * After swapping  we get
 * So, we need a minimum of  swaps to sort the array in ascending order.
 *
 * Sample Input 1
 *
 * 5
 * 2 3 4 1 5
 * Sample Output 1
 *
 * 3
 * Explanation 1
 *
 * Given array
 * After swapping  we get
 * After swapping  we get
 * After swapping  we get
 * So, we need a minimum of  swaps to sort the array in ascending order.
 *
 * Sample Input 2
 *
 * 7
 * 1 3 5 2 4 6 7
 * Sample Output 2
 *
 * 3
 * Explanation 2
 *
 * Given array
 * After swapping  we get
 * After swapping  we get
 * After swapping  we get
 * So, we need a minimum of  swaps to sort the array in ascending order.
 */
// Complete the minimumSwaps function below.
fun minimumSwaps(arr: Array<Int>): Int {
    var minimumSwapsCount = 0
    var index = 0
    while(index < arr.lastIndex) {
        if (arr[index] == index + 1) {
            index++
        }else {
            val value = arr[index]
            val temp = arr[value - 1]
            arr[value - 1] = value
            arr[index] = temp
            minimumSwapsCount++
        }
    }

    return minimumSwapsCount
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val res = minimumSwaps(arr)

    println(res)
}
