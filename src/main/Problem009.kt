package main

/**
 * Special Pythagorean triplet
 * https://main.net/problem=9
 */

fun main(args: Array<String>) {
    fun a(n:Int, m:Int) =  n * n - m * m
    fun b(n:Int, m:Int) = 2 * n * m
    fun c(n:Int, m:Int) =  n * n + m * m
    fun pythagorean(n:Int, m:Int):List<Int> = listOf(a(n, m), b(n, m), c(n, m))


    val n = 1000
    val limit = Math.sqrt(n.toDouble()/2).toInt()
    val r =  (limit downTo 1).asSequence()
            .flatMap { i -> (1..limit).map { j -> pythagorean(i, j) }.asSequence() }
            .find { it.sum() == 1000 }

    println(r?.product())
}
