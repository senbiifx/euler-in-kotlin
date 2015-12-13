package main

/**
 *  Amicable numbers
 *  https://main.net/problem=21
 *
 *  3 · 2n - 1,   3 · 2n+1 - 1,   and    32 · 22n+1 - 1   are all prime, then
 *  2n+1(3 · 2n - 1)(3 · 2n+1 - 1)    and    2n+1(32 · 22n+1 - 1)
 */

fun main(args: Array<String>) {

    val amicable = sequence(0){it + 2}
                    .map { Pair(it, sumOfDivisors(it)) }
                    .filterNot { it.first == it.second }
                    .filter { it.first == sumOfDivisors(it.second) }


    val amicableNumbers =
            amicable.takeWhile { it.first < 10000 || it.second < 10000 }
                    .flatMap { it.toList().asSequence() }
                    .distinct()
    println(amicableNumbers.sum())
    //~100ms
}
