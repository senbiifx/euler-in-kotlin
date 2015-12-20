package main

/**
 * Digit fifth powers
 * https://projecteuler.net/problem=30
 */

fun main(args: Array<String>) {
    val upperBound = 9L.pow(5) * 6
    val range = (2..upperBound)
    fun Long.fifthPowDigitSum() = this.toDigitsList().map { it.pow(5) }.sum()
    val sum = range.asSequence()
                   .filter { it == it.fifthPowDigitSum() }
                   .sum()
    println(sum)
}