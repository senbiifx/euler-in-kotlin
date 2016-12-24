package main

/**
 *  Number letter counts
 *  https://projecteuler.net/problem=17
 */

fun main(args: Array<String>) {

    val ones = listOf(3, 3, 5, 4, 4, 3, 5, 5, 4).sum() //1 - 9
    val teens = listOf(3, 6, 6, 8, 8, 7, 7, 9, 8, 8).sum() //10 - 19
    val tens = listOf(6, 6, 5, 5, 5, 7, 6, 6).sum() //20, 30,... 90
    val and = 3
    val hundred = 7

    val totalTeens = teens * 10
    val totalOnes = ones * 9 * 10
    val totalTens = tens * 10 * 10
    val totalHundred = ones * 100 +  hundred * 100 * 9
    val totalAnd = and * 99 * 9
    val onethousand = "onethousand".length

    val total = onethousand + totalHundred + totalAnd + totalTeens +
                totalTens + totalOnes + totalTeens

    println(total)
}
