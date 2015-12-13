package main

/**
 * Summation of primes
 * https://main.net/problem=10
 */

fun main(args: Array<String>) {

    val sum: Long = sieve(2000000)
            .asSequence()
            .withIndex()
            .filter { it.value }
            .map { it.index.toLong() }
            .sum()

    println(sum)
    // ~200 ms
}
