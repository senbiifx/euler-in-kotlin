package main

/**
 * Multiples of 3 and 5
 * https://main.net/problem=1
 */

fun main(args: Array<String>) {

    val sum = (1..999).asSequence().filter { it.dividesBy(3) || it.dividesBy(5) }.sum()
    println(sum)
}
