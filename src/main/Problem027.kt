package main

/**
 * Quadratic primes
 * https://projecteuler.net/problem=27
 */

fun main(args: Array<String>) {
    /*
        given that n² – 79n + 1601 can produce 80 primes,
        we can assume that the max n could be
        n² + an + b = 87400  where a  = 1000, b = 1000 since
        |a| < 1000 and |b| < 1000
     */
    fun quadratic(n:Int, a:Int, b:Int) = n.pow(2) + a * n + b
    val nRange = (0..87400)
    val isPrime = sieve(87400)
    val list = (-1000..1000)
    val c = list.flatMap { a ->
        list.map { b ->
            nRange.takeWhile { n -> isPrime[Math.abs(quadratic(n, a, b))] }.count() }}

    println(c.max())
    //~30ms
}