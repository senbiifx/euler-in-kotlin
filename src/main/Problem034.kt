package main

/**
 * Digit factorials
 * https://projecteuler.net/problem=34
 */

fun main(args: Array<String>) {
    val f = listOf(1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880)
    val digitFactorial = { n: Int -> n == n.toDigitsList().map { f[it] }.sum() }
    val limit = 999999
    val sum = (3..limit).filter(digitFactorial).sum()
    println(sum)
}