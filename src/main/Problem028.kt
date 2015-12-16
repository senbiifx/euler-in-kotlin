package main

/**
 * Number spiral diagonals
 * https://projecteuler.net/problem=28
 */

fun main(args: Array<String>) {

    fun diagonalSum(dim:Int)=
        (3..dim).step(2)
                .fold(1){ acc, i -> acc + 4 * (i-2).pow(2) + (i - 1) * 10 }

    println(diagonalSum(1001))

}
