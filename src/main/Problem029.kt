package main

/**
 * Distinct powers
 * https://projecteuler.net/problem=29
 */

fun main(args: Array<String>) {
    val range = (2..100).asSequence()
    val powers = range.flatMap { i -> range.map { j -> bigInt(i).pow( j ) } }
    val distinct = powers.distinct()

    println(distinct.count())
}