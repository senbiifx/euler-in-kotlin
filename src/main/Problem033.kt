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

    val product = fractions.reduce { a, b ->  Pair(a.first * b.first, a.second * b.second) }

    val solution = product.second / gcf(product.first, product.second)

    println(solution)
}