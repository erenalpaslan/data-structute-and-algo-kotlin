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
 * An avid hiker keeps meticulous records of their hikes. During the last hike that took exactly  steps, for every step it was noted if it was an uphill, , or a downhill,  step. Hikes always start and end at sea level, and each step up or down represents a  unit change in altitude. We define the following terms:
 *
 * A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
 * A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
 * Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.
 *
 * Example
 *
 *
 *
 * The hiker first enters a valley  units deep. Then they climb out and up onto a mountain  units high. Finally, the hiker returns to sea level and ends the hike.
 *
 * Function Description
 *
 * Complete the countingValleys function in the editor below.
 *
 * countingValleys has the following parameter(s):
 *
 * int steps: the number of steps on the hike
 * string path: a string describing the path
 * Returns
 *
 * int: the number of valleys traversed
 * Input Format
 *
 * The first line contains an integer , the number of steps in the hike.
 * The second line contains a single string , of  characters that describe the path.
 *
 * Constraints
 *
 * Sample Input
 *
 * 8
 * UDDDUDUU
 * Sample Output
 *
 * 1
 *
 */
/*
 * Complete the 'countingValleys' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER steps
 *  2. STRING path
 */

fun countingValleys(steps: Int, path: String): Int {
    // Write your code here
    var totalValleyCount = 0
    var isHikerEnteredToValley = false
    var hikerSeaLevel = 0
    for (i in 0 until steps) {
        when(path[i]) {
            'U' -> hikerSeaLevel++
            'D' -> hikerSeaLevel--
        }
        if (hikerSeaLevel < 0) {
            isHikerEnteredToValley = true
        }else {
            if (isHikerEnteredToValley) {
                totalValleyCount++
            }
            isHikerEnteredToValley = false
        }
    }

    return totalValleyCount
}

fun main(args: Array<String>) {
    val steps = readLine()!!.trim().toInt()

    val path = readLine()!!

    val result = countingValleys(steps, path)

    println(result)
}
