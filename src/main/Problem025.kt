package main

/**
 * 1000-digit Fibonacci number
 * https://projecteuler.net/problem=25
 */

fun main(args: Array<String>) {

    val fibonacci = generateSequence(bigInt(0) to bigInt(1))
            { p -> p._2 to p._1 + p._2 }

    val limit = bigInt(10).pow(999)
    val index = fibonacci.indexOfFirst { limit < it.second } + 1

    println(index)
    //2ms
}
