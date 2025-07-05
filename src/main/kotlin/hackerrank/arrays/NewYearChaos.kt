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
import kotlin.math.abs
import kotlin.math.absoluteValue
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*


/**
 * It is New Year's Day and people are in line for the Wonderland rollercoaster ride. Each person wears a sticker indicating their initial position in the queue from  to . Any person can bribe the person directly in front of them to swap positions, but they still wear their original sticker. One person can bribe at most two others.
 *
 * Determine the minimum number of bribes that took place to get to a given queue order. Print the number of bribes, or, if anyone has bribed more than two people, print Too chaotic.
 *
 * Example
 *
 *
 * If person  bribes person , the queue will look like this: . Only  bribe is required. Print 1.
 *
 *
 * Person  had to bribe  people to get to the current position. Print Too chaotic.
 *
 * Function Description
 *
 * Complete the function minimumBribes in the editor below.
 *
 * minimumBribes has the following parameter(s):
 *
 * int q[n]: the positions of the people after all bribes
 * Returns
 *
 * No value is returned. Print the minimum number of bribes necessary or Too chaotic if someone has bribed more than  people.
 * Input Format
 *
 * The first line contains an integer , the number of test cases.
 *
 * Each of the next  pairs of lines are as follows:
 * - The first line contains an integer , the number of people in the queue
 * - The second line has  space-separated integers describing the final state of the queue.
 *
 * Constraints
 *
 * Subtasks
 *
 * For  score
 *
 * Sample Input
 *
 * STDIN       Function
 * -----       --------
 * 2           t = 2
 * 5           n = 5
 * 2 1 5 3 4   q = [2, 1, 5, 3, 4]
 * 5           n = 5
 * 2 5 1 3 4   q = [2, 5, 1, 3, 4]
 * Sample Output
 *
 * 3
 * Too chaotic
 */
/*
 * Complete the 'minimumBribes' function below.
 *
 * The function accepts INTEGER_ARRAY q as parameter.
 *
 * 1 2 3 4 5 6 7 8 9
 * 1 2 5 3 7 8 6 4 9
 * 2 + 2 + 2 + 1
 */
fun minimumBribes(q: Array<Int>): Unit {
    var bribes = 0
    var p1 = 1
    var p2 = 2
    var p3 = 3
    for(i in 0 .. q.lastIndex) {
        if (q[i] == p1) {
            p1 = p2
            p2 = p3
            p3++
        }else if (q[i] == p2) {
            bribes++
            p2 = p3
            p3++
        }else if (q[i] == p3) {
            bribes += 2
            p3++
        }else {
            println("Too chaotic")
            return
        }
    }

    println(bribes)
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()

        val q = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

        minimumBribes(q)
    }
}
