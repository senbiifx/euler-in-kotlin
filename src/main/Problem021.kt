package main

/**
 *  Amicable numbers
 *  https://projecteuler.net/problem=21
 */

fun main(args: Array<String>) {

    val amicable = generateSequence(0, plus(2) )
                    .map {  it to sumOfDivisors(it) }
                    .filterNot { it._1 == it._2 }
                    .filter { it._1 == sumOfDivisors(it._2) }


    val amicableNumbers =
            amicable.takeWhile { it._1 < 10000 || it._2 < 10000 }
                    .flatMap { it.toList().asSequence() }
                    .distinct()

    println(amicableNumbers.sum())
    //~100ms
}
