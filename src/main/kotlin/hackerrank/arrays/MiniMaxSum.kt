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
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.
 *
 * Example
 *
 * The minimum sum is  and the maximum sum is . The function prints
 *
 * 16 24
 * Function Description
 *
 * Complete the miniMaxSum function in the editor below.
 *
 * miniMaxSum has the following parameter(s):
 *
 * arr: an array of  integers
 * Print
 *
 * Print two space-separated integers on one line: the minimum sum and the maximum sum of  of  elements.
 *
 * Input Format
 *
 * A single line of five space-separated integers.
 *
 * Constraints
 *
 *
 * Output Format
 *
 * Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers. (The output can be greater than a 32 bit integer.)
 *
 * Sample Input
 *
 * 1 2 3 4 5
 * Sample Output
 *
 * 10 14
 * Explanation
 *
 * The numbers are , , , , and . Calculate the following sums using four of the five integers:
 *
 * Sum everything except , the sum is .
 * Sum everything except , the sum is .
 * Sum everything except , the sum is .
 * Sum everything except , the sum is .
 * Sum everything except , the sum is .
 */
/*
1. DEF
     - An array will be given with 5 element sum 4 of them and find the minimum and maximum calculation
     - print like "$min $max"
     - array have 5 items
     - not sorted

2. BOUNDARIES
    - integer array
    - Unit, print the result "$min $max"

3. TEST CASES
    [1,2,3,4,5] -> "10 14"
    [2,5,0,0,0,1] -> "1 8"

4. PSEUDO CODE
    sort the array
    "[0,4].sum() [lastIndex - 4,lastIndex].sum()"

 */

/*
 * Complete the 'miniMaxSum' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun miniMaxSum(arr: Array<Int>): Unit {
    // Write your code here
    arr.sort()
    val min = arr.slice(0 until 4).sumOf { it.toLong() }
    val max = arr.slice(arr.size - 4 until arr.size).sumOf { it.toLong() }
    println("$min $max")
}

fun main(args: Array<String>) {

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    miniMaxSum(arr)
}
