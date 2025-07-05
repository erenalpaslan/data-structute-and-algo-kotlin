package hackerrank.stringmanipulation

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
 * A student is taking a cryptography class and has found anagrams to be very useful. Two strings are anagrams of each other if the first string's letters can be rearranged to form the second string. In other words, both strings must contain the same exact letters in the same exact frequency. For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.
 *
 * The student decides on an encryption scheme that involves two large strings. The encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. Determine this number.
 *
 * Given two strings,  and , that may or may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.
 *
 * Example
 *
 *
 * Delete  from  and  from  so that the remaining strings are  and  which are anagrams. This takes  character deletions.
 *
 * Function Description
 *
 * Complete the makeAnagram function in the editor below.
 *
 * makeAnagram has the following parameter(s):
 *
 * string a: a string
 * string b: another string
 * Returns
 *
 * int: the minimum total characters that must be deleted
 * Input Format
 *
 * The first line contains a single string, .
 * The second line contains a single string, .
 *
 * Constraints
 *
 * The strings  and  consist of lowercase English alphabetic letters, ascii[a-z].
 * Sample Input
 *
 * cde
 * abc
 * Sample Output
 *
 * 4
 * Explanation
 *
 * Delete the following characters from the strings make them anagrams:
 *
 * Remove d and e from cde to get c.
 * Remove a and b from abc to get c.
 * It takes  deletions to make both strings anagrams.
 */
/*
 * Complete the 'makeAnagram' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING a
 *  2. STRING b
 */

fun makeAnagram(a: String, b: String): Int {
    val aCharMap = mutableMapOf<Char, Int>()
    var bMatchCharCount = 0
    for (char in a) {
        aCharMap.put(char, aCharMap.getOrDefault(char, 0) + 1)
    }

    for(i in b) {
        val value = aCharMap.getOrDefault(i, 0)
        if (value > 0) {
            aCharMap.put(i, value - 1)
            bMatchCharCount++
        }
    }

    val deletionCount = (b.length - bMatchCharCount) +
            aCharMap.filter { it.value > 0 }.map { it.value }.sum()
    return deletionCount
}

fun main(args: Array<String>) {
    val a = readLine()!!

    val b = readLine()!!

    val res = makeAnagram(a, b)

    println(res)
}
