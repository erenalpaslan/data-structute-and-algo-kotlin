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
 * There is a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads and others are cumulus. The player can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus  or . The player must avoid the thunderheads. Determine the minimum number of jumps it will take to jump from the starting postion to the last cloud. It is always possible to win the game.
 *
 * For each game, you will get an array of clouds numbered  if they are safe or  if they must be avoided.
 *
 * Example
 *
 * Index the array from . The number on each cloud is its index in the list so the player must avoid the clouds at indices  and . They could follow these two paths:  or . The first path takes  jumps while the second takes . Return .
 *
 * Function Description
 *
 * Complete the jumpingOnClouds function in the editor below.
 *
 * jumpingOnClouds has the following parameter(s):
 *
 * int c[n]: an array of binary integers
 * Returns
 *
 * int: the minimum number of jumps required
 * Input Format
 *
 * The first line contains an integer , the total number of clouds. The second line contains  space-separated binary integers describing clouds  where .
 *
 * Constraints
 *
 * Output Format
 *
 * Print the minimum number of jumps needed to win the game.
 *
 * Sample Input 0
 *
 * 7
 * 0 0 1 0 0 1 0
 * Sample Output 0
 *
 * 4
 */
/*
 * Complete the 'jumpingOnClouds' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY c as parameter.
 */

fun jumpingOnClouds(c: Array<Int>): Int {
    // Write your code here
    var totalJumpCount = 0
    var currentCloudIndex = 0
    while(currentCloudIndex < c.lastIndex) {
        if (currentCloudIndex != c.lastIndex - 1 && c[currentCloudIndex+2] == 0) {
            currentCloudIndex += 2
        }else {
            currentCloudIndex += 1
        }
        totalJumpCount++
    }

    return totalJumpCount
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val c = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = jumpingOnClouds(c)

    println(result)
}
