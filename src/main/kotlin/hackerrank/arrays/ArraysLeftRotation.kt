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
 * A left rotation operation on an array shifts each of the array's elements  unit to the left. For example, if  left rotations are performed on array , then the array would become . Note that the lowest index item moves to the highest index in a rotation. This is called a circular array.
 *
 * Given an array  of  integers and a number, , perform  left rotations on the array. Return the updated array to be printed as a single line of space-separated integers.
 *
 * Function Description
 *
 * Complete the function rotLeft in the editor below.
 *
 * rotLeft has the following parameter(s):
 *
 * int a[n]: the array to rotate
 * int d: the number of rotations
 * Returns
 *
 * int a'[n]: the rotated array
 * Input Format
 *
 * The first line contains two space-separated integers  and , the size of  and the number of left rotations.
 * The second line contains  space-separated integers, each an .
 *
 * Constraints
 *
 * Sample Input
 *
 * 5 4
 * 1 2 3 4 5
 * Sample Output
 *
 * 5 1 2 3 4
 *
 */

/*
 * Complete the 'rotLeft' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY a
 *  2. INTEGER d
 */

fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    // Write your code here
    val operatableItemCount = a.size - (a.size - d)
    println(operatableItemCount.toString() + " REM => ${(a.size % d)}")
    val leftList = mutableListOf<Int>()
    val rightList = mutableListOf<Int>()
    for (i in 0 until a.size) {
        if (i < operatableItemCount) {
            leftList.add(a[i])
        }else {
            rightList.add(a[i])
        }
    }

    return (rightList + leftList).toTypedArray()
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val d = first_multiple_input[1].toInt()

    val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = rotLeft(a, d)

    println(result.joinToString(" "))
}
