package hackerrank.warmup

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
 * There is a large pile of socks that must be paired by color. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
 *
 * Example
 *
 *
 * There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .
 *
 * Function Description
 *
 * Complete the sockMerchant function in the editor below.
 *
 * sockMerchant has the following parameter(s):
 *
 * int n: the number of socks in the pile
 * int ar[n]: the colors of each sock
 * Returns
 *
 * int: the number of pairs
 * Input Format
 *
 * The first line contains an integer , the number of socks represented in .
 * The second line contains  space-separated integers, , the colors of the socks in the pile.
 *
 * Constraints
 *
 *  where
 * Sample Input
 *
 * STDIN                       Function
 * -----                       --------
 * 9                           n = 9
 * 10 20 20 10 10 30 50 10 20  ar = [10, 20, 20, 10, 10, 30, 50, 10, 20]
 * Sample Output
 *
 * 3
 */
/*
 * Complete the 'sockMerchant' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY ar
 */

fun sockMerchant(n: Int, ar: Array<Int>): Int {
    // Write your code here
    var totalPairCount = 0
    val uniqueColors = mutableSetOf<Int>()
    for (i in 0 until n) {
        uniqueColors.add(ar[i])
    }

    for (color in uniqueColors) {
        var colorPairCount = 0
        for (i in 0 until ar.size) {
            if (ar[i] == color) {
                colorPairCount++
            }
        }
        totalPairCount += (colorPairCount / 2)
    }

    return totalPairCount
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val ar = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}
