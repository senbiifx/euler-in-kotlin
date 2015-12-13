package main

/**
 * Lexicographic permutations
 * https://main.net/problem=24
 */

fun main(args: Array<String>) {

    //Reference implementation: https://en.wikipedia.org/wiki/Factorial_number_system

    fun factoradic(n: Int,div: Int = 1,
                   list: List<Int> = listOf()): List<Int> = when (n) {
        0 -> list
        else -> factoradic(n / div, div + 1) + (n % div)
    }

    data class Accumulator<T>(val remaining:List<T>, val output:List<T>)

    fun <T> permutation(list: List<T>, nth: Int):List<T>{
        val initial = Accumulator(list, emptyList())
        val nthPermutation = factoradic(nth).fold(initial){ acc, next:Int ->
            Accumulator(
                    acc.remaining - acc.remaining[next],
                    acc.output + acc.remaining[next]
            )
        }
        return nthPermutation.output
    }

    println(permutation(listOf(0,1,2,3,4,5,6,7,8,9), 999999))
    //~30 ms
}



