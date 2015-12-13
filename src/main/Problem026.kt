package main

/**
 * Reciprocal cycles
 * https://projecteuler.net/problem=26
 */

fun main(args: Array<String>) {

    //http://mathworld.wolfram.com/MultiplicativeOrder.html
    val multiplicativeOrder = { i: Int ->
        (1..i - 1).asSequence().find { j ->
            bigInt(10).modPow(bigInt(j), bigInt(i)) <= bigInt(1)
        } ?: 0
    }

    val d = (2..999).map(multiplicativeOrder)

    println(d.indexOf(d.max()) + 2)
    //~3ms
}
