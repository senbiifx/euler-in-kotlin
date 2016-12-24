package main

/**
 * Digit cancelling fractions
 * https://projecteuler.net/problem=33
 */
fun main(args: Array<String>) {

    val fractions = (1..10).flatMap { i ->
                        (1..10).flatMap { d ->
                            (1..d - 1).filter { n -> d * (10 * n + i) == n * (10 * i + d) }
                                      .map    { n -> Pair(n, d) }
                         }
                     }

    val product = fractions.reduce { a, b ->  Pair(a._1 * b._1, a._2 * b._2) }

    val solution = product._2 / gcf(product._1, product._2)

    println(solution)
}