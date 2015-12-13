package main

/**
 *Highly divisible triangular number
 *https://main.net/problem=12
 */

fun main(args: Array<String>) {

    fun divisorsCount(n:Long):Int{
        return primeFactors(n).groupBy { it }
                              .map { it.value.size + 1 }
                              .reduce{x, y -> x * y}
    }

    val triangles: Sequence<Long> = sequence (1L){ it + 1 }.map { it * (it + 1) / 2 }

    val x = System.currentTimeMillis()
    val tri:Long = triangles.first { divisorsCount(it) > 500 }
    println(tri) //~250ms
    println(System.currentTimeMillis() - x)
}