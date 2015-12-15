package main

/**
 * Even Fibonacci numbers
 * https://main.net/problem=2
 */

fun main(args: Array<String>) {

    val fibonacci = sequence(0 to 1) { p -> p.second to p.first + p.second }

    val sum: Int = fibonacci.takeWhile { it.second < 4000000 }
                            .map { it.second }
                            .filter( dividesBy(2) )
                            .sum()
    println(sum)
}
