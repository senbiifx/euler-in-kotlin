package main

/**
 * 10001st prime
 * https://main.net/problem=7
 */

fun main(args: Array<String>) {

    val prime = sequence(1, { it + 2})
                .filter { n->
                    (3..Math.sqrt(n.toDouble()).toInt())
                    .step(2)
                    .none { n % it == 0 }
                }

    println(prime.take(10001).last())

}
