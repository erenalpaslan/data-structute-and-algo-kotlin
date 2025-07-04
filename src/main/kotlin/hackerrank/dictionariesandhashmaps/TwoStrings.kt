package hackerrank.dictionariesandhashmaps

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
 * Given two strings, determine if they share a common substring. A substring may be as small as one character.
 *
 * Example
 *
 *
 * These share the common substring .
 *
 *
 *
 * These do not share a substring.
 *
 * Function Description
 *
 * Complete the function twoStrings in the editor below.
 *
 * twoStrings has the following parameter(s):
 *
 * string s1: a string
 * string s2: another string
 * Returns
 *
 * string: either YES or NO
 * Input Format
 *
 * The first line contains a single integer , the number of test cases.
 *
 * The following  pairs of lines are as follows:
 *
 * The first line contains string .
 * The second line contains string .
 * Constraints
 *
 *  and  consist of characters in the range ascii[a-z].
 * Output Format
 *
 * For each pair of strings, return YES or NO.
 *
 * Sample Input
 *
 * 2
 * hello
 * world
 * hi
 * world
 * Sample Output
 *
 * YES
 * NO
 */
/*
 * Complete the 'twoStrings' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. STRING s1
 *  2. STRING s2
 */

fun twoStrings(s1: String, s2: String): String {
    // Write your code here
    val s2HashSet = s2.toHashSet()
    val s1HashSet = s1.toHashSet()
    s2HashSet.forEach { char ->
        if (s1HashSet.contains(char)) {
            return "YES"
        }
    }

    return "NO"
}

/**
 * Brute force solution
 */
/*fun twoStrings(s1: String, s2: String): String {
    // Write your code here
    for (i in 0 until s1.length) {
        for(j in 0 until s2.length) {
            if (s1[i] == s2[j]) {
                return "YES"
            }
        }
    }

    return "NO"
}*/

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s1 = readLine()!!

        val s2 = readLine()!!

        val result = twoStrings(s1, s2)

        println(result)
    }
}
