package main

/**
 * Truncatable primes
 * https://projecteuler.net/problem=37
 * #y
 */

fun main(args: Array<String>) {

    fun Int.isLeftTruncatable() : Boolean
            = if(this == 0) true else isPrime() && (this % 10.pow(length() - 1)).isLeftTruncatable()

    fun truncatablePrimes() : List<Int>{
        val list = listOf(1, 3, 5, 7, 9)
        val limit = 11

        tailrec fun search(tp : List<Int>, space : List<Int>) : List<Int>{
            if(tp.size >= limit) return tp
            val next = space.flatMap { i -> list.map { j -> i concat j } }
                            .filter(Int::isPrime)
            val truncatables = next.filter(Int::isLeftTruncatable)

            return  search(tp + truncatables, next )
        }

        return search(emptyList(), listOf(2, 3, 5, 7))
    }

    println(truncatablePrimes().sum())
}