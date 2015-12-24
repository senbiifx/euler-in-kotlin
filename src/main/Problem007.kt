package main

/**
 * 10001st prime
 * https://main.net/problem=7
 */

fun main(args: Array<String>) {
    val prime = sequence(1, { it + 2}).filter { n-> n.isPrime() }

    println(prime.take(10001).last())
}
