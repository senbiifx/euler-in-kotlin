package main

/**
 * Quadratic primes
 * https://projecteuler.net/problem=27
 * #y
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
    val isPrime = esieve(87400)
    val list = (-1000..1000)

    val combinations = list.asSequence().flatMap { a -> list.asSequence().map { b -> a to b} }
    val pairWithMaxPrime = combinations.maxBy { p ->
        nRange.takeWhile { n -> isPrime[quadratic(n, p.first, p.second).abs()] }.count()
    }

    val product = pairWithMaxPrime!!.first * pairWithMaxPrime!!.second

    println(product)
    //~3ms
}
