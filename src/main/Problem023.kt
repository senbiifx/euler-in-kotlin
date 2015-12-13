package main

/**
 * Non-abundant sums
 * Problem 23
 */

fun main(args: Array<String>) {


    val limit = 28123

    val abundant = (1..limit).asSequence().filter { it < sumOfDivisors(it) }.toList()

    //Could be optimized by using imperative nested loops
    val sums = abundant.asSequence().flatMap { i ->
        abundant.asSequence()
                .takeWhile { it <= limit - i }
                .map { i + it }
    }

    val total = (1..limit).minus( sums ).sum()

    println(total)

}
