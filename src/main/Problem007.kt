package main

/**
 * 10001st prime
 * https://projecteuler.net/problem=7
 */

fun main(args: Array<String>) {

    val prime = generateSequence(1, plus(2) ).filter( Int::isPrime )

    println(prime.take(10001).last())
}
