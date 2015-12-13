package main

import kotlin.math.plus

/**
 * 1000-digit Fibonacci number
 * https://main.net/problem=25
 */

fun main(args: Array<String>) {

    val fibonacci = sequence(bigInt(0) to bigInt(1))
            { p -> p.second to p.first +  p.second }

    val limit = bigInt(10).pow(999)
    val index = fibonacci.indexOfFirst { limit < it.second } + 1

    println(index) //2ms
}