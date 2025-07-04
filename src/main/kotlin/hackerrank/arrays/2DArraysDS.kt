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
 * Given a  2D array, , an hourglass is a subset of values with indices falling in the following pattern:
 *
 * a b c
 *   d
 * e f g
 * There are  hourglasses in a  array. The  is the sum of the values in an hourglass. Calculate the hourglass sum for every hourglass in , then print the  hourglass sum.
 *
 * Example
 *
 *
 * -9 -9 -9  1 1 1
 *  0 -9  0  4 3 2
 * -9 -9 -9  1 2 3
 *  0  0  8  6 6 0
 *  0  0  0 -2 0 0
 *  0  0  1  2 4 0
 * The  hourglass sums are:
 *
 * -63, -34, -9, 12,
 * -10,   0, 28, 23,
 * -27, -11, -2, 10,
 *   9,  17, 25, 18
 * The highest hourglass sum is  from the hourglass beginning at row , column :
 *
 * 0 4 3
 *   1
 * 8 6 6
 * Note: If you have already solved the Java domain's Java 2D Array challenge, you may wish to skip this challenge.
 *
 * Function Description
 *
 * Complete the function  with the following parameter(s):
 *
 * : a 2-D array of integers
 * Returns
 *
 * : the maximum hourglass sum
 * Input Format
 *
 * Each of the  lines of inputs  contains  space-separated integers .
 *
 * Constraints
 *
 * Sample Input
 *
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 * Sample Output
 * 19
 */
/*
 * Complete the 'hourglassSum' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
 *
 * Başlangıç noktasını belirten bir loop
 * Hourglass için bir loop
 * toplam değeri tutan bir değişken toplama bittikten sonra max değerden büyükse max değeri güncelle
 * max değeri tutan bir değişken
 */
fun hourglassSum(arr: Array<Array<Int>>): Int {
    // Write your code here
    var maxSum: Int? = null
    val endOfArray = arr.lastIndex - 2
    for (verticalIndex in 0..endOfArray) {
        for(horizontalIndex in 0..endOfArray) {
            val total = arr[verticalIndex][horizontalIndex] +
                    arr[verticalIndex][horizontalIndex + 1] +
                    arr[verticalIndex][horizontalIndex + 2] +
                    arr[verticalIndex + 1][horizontalIndex + 1] +
                    arr[verticalIndex + 2][horizontalIndex] +
                    arr[verticalIndex + 2][horizontalIndex + 1] +
                    arr[verticalIndex + 2][horizontalIndex + 2]
            if (maxSum == null || total >= maxSum) maxSum = total
        }
    }

    return maxSum ?: 0
}

fun main(args: Array<String>) {

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}
