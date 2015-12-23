package main

/**
 * Digit fifth powers
 * https://projecteuler.net/problem=30
 */

fun main(args: Array<String>) {
    val upperBound = 9L.pow(5) * 6
    val range = (2..upperBound)
    val pow = listOf(0L, 1, 32, 243, 1024, 3125, 7776, 16807, 32768, 59049)
    fun Long.fifthPowDigitSum() = this.toDigitsList().map { pow[it.toInt()] }.sum()
    val sum = range.asSequence()
                   .filter { it == it.fifthPowDigitSum() }
                   .sum()
    println(sum)
}