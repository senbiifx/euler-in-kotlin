package main

/**
 * Even Fibonacci numbers
 * https://projecteuler.net/problem=2
 */
fun main(args: Array<String>) {

    val fibonacci = generateSequence(0 to 1) { p -> p.second to p.first + p.second }

    val sum: Int = fibonacci.takeWhile { it._2 < 4000000 }
                            .map { it._2 }
                            .filter( dividesBy(2) )
                            .sum()
    println(sum)
}
