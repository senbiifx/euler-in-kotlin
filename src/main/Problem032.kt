package main

import java.lang.Math.*

/**
 * Pandigital products
 * https://projecteuler.net/problem=32
 */
fun main(args: Array<String>) {
    //reference implementation: http://www.mathblog.dk/project-euler-32-pandigital-products/

    val pandigitalProduct = { expr: Triple<Long, Long, Long> ->
        val concatenated = expr.first concat expr.second concat expr.third
        concatenated.length() == 9 && concatenated.isPandigital()
    }

    val sum = (1..10000L).flatMap { m -> (1..10000L / m).map { n -> Triple(m, n, m * n) } }
                         .filter( pandigitalProduct )
                         .map { it.third }
                         .distinct()
                         .sum()
    println(sum)
}