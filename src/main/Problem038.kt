package main

/**
 * Pandigital multiples
 * Problem 38
 */

fun main(args: Array<String>) {
    val concatenatedProduct =  { i : Long ->
        (1..10 / i.length() ).fold(0L){ x, y -> x concat (i * y) } }

    val pandigitals = (99999L downTo 1).asSequence()
                                       .map(concatenatedProduct)
                                       .filter(Long::isPandigital)

    println(pandigitals.first())
}