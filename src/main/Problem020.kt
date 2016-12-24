package main

/**
 * Factorial digit sum
 * https://projecteuler.net/problem=20
 */

fun main(args: Array<String>) {

    val sum = factorial(100).toString()
                            .map { it.toString().toInt() }
                            .sum()
    println(sum)

}
