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
 * Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in the array.
 *
 * Example
 *
 *
 * Queries are interpreted as follows:
 *
 *     a b k
 *     1 5 3
 *     4 8 7
 *     6 9 1
 * Add the values of  between the indices  and  inclusive:
 *
 * image
 *
 * The largest value is  after all operations are performed.
 *
 * Function Description
 *
 * Complete the function  with the following parameters:
 *
 * the number of elements in the array
 * : a two-dimensional array of queries where each  contains three integers, , , and .
 * Returns
 *
 * : the maximum value in the resultant array
 * Input Format
 *
 * The first line contains two space-separated integers  and , the size of the array and the number of queries.
 * Each of the next  lines contains three space-separated integers ,  and , the left index, right index and number to add.
 *
 * Constraints
 *
 * Sample Input
 *
 * STDIN       Function
 * -----       --------
 * 5 3         arr[] size n = 5, queries[] size q = 3
 * 1 2 100     queries = [[1, 2, 100], [2, 5, 100], [3, 4, 100]]
 * 2 5 100
 * 3 4 100
 * Sample Output
 *
 * 200
 * Explanation
 *
 * After the first update the list is 100 100 0 0 0.
 * After the second update list is 100 200 100 100 100.
 * After the third update list is 100 200 200 200 100.
 *
 * The maximum value is .
 */
/*
 * Complete the 'arrayManipulation' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. 2D_INTEGER_ARRAY queries
 */

fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    val resultArray = Array<Long>(n) { 0L }
    var maxValue = 0L
    for (i in 0 until queries.size) {
        val operationArray = queries[i]
        val startIndex = operationArray[0] - 1
        val endIndex = operationArray[1] - 1
        val value = operationArray[2]
        for (j in startIndex .. endIndex) {
            resultArray[j] += value.toLong()
            maxValue = resultArray[j].coerceAtLeast(maxValue)
        }
    }

    return maxValue
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val m = first_multiple_input[1].toInt()

    val queries = Array<Array<Int>>(m, { Array<Int>(3, { 0 }) })

    for (i in 0 until m) {
        queries[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = arrayManipulation(n, queries)

    println(result)
}
