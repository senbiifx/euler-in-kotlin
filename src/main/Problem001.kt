package main

/**
 * Multiples of 3 and 5
 * https://projecteuler.net/problem=1
 */
fun main(args: Array<String>) {

    val sum = (1..999).asSequence()
                      .filter(dividesBy(3))
                      .filter(dividesBy(5))
                      .sum()
    println(sum)
}
