package hackerrank.sorting

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
 * Mark and Jane are very happy after having their first child. Their son loves toys, so Mark wants to buy some. There are a number of different toys lying in front of him, tagged with their prices. Mark has only a certain amount to spend, and he wants to maximize the number of toys he buys with this money. Given a list of toy prices and an amount to spend, determine the maximum number of gifts he can buy.
 *
 * Note Each toy can be purchased only once.
 *
 * Example
 *
 *
 * The budget is  units of currency. He can buy items that cost  for , or  for  units. The maximum is  items.
 *
 * Function Description
 *
 * Complete the function maximumToys in the editor below.
 *
 * maximumToys has the following parameter(s):
 *
 * int prices[n]: the toy prices
 * int k: Mark's budget
 * Returns
 *
 * int: the maximum number of toys
 * Input Format
 *
 * The first line contains two integers,  and , the number of priced toys and the amount Mark has to spend.
 * The next line contains  space-separated integers
 *
 * Constraints
 *
 *
 *
 *
 * A toy can't be bought multiple times.
 *
 * Sample Input
 *
 * 7 50
 * 1 12 5 111 200 1000 10
 * Sample Output
 *
 * 4
 * Explanation
 *
 * He can buy only  toys at most. These toys have the following prices: .
 */
/*
 * Complete the 'maximumToys' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY prices
 *  2. INTEGER k
 */

fun maximumToys(prices: Array<Int>, k: Int): Int {
    // Write your code here
    var toyCount = 0
    var amount = k
    prices.sort()

    for (price in prices) {
        if (price <= amount) {
            amount -= price
            toyCount++
        }
    }

    return toyCount
}

/**
 * Brute force solution
 */
/*fun maximumToys(prices: Array<Int>, k: Int): Int {
    // Write your code here
    var toyCount = 0
    var amount = k
    for (i in 0 until prices.size) {
        for (j in 0 until prices.lastIndex) {
            if (prices[j] > prices[j + 1]) {
                val temp = prices[j]
                prices[j] = prices[j + 1]
                prices[j + 1] = temp
            }
        }
    }


    for (price in prices) {
        if (price <= amount) {
            amount -= price
            toyCount++
        }
    }

    return toyCount
}*/

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val k = first_multiple_input[1].toInt()

    val prices = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = maximumToys(prices, k)

    println(result)
}
