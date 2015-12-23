package main

/**
 * Circular primes
 * Problem 35
 */

fun main(args: Array<String>) {
    val isPrime = esieve(1000000)
    fun Int.rotate() = this / 10 + this % 10 * 10.pow(length() - 1)
    val circularPrime = { n: Int ->
        tailrec fun circularPrime(n: Int, len: Int): Boolean = when {
            !isPrime[n] -> false
            len == 0 -> true
            else -> circularPrime(n.rotate(), len - 1)
        }
        circularPrime(n, n.length())
    }

    val primes = (1..999999).filter(circularPrime)
    println(primes.count())
}