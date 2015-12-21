package main

/**
 * Coin sums
 * https://projecteuler.net/problem=31
 */

fun main(args: Array<String>) {

    fun coinSums(n : Int, denominations : List<Int>) : Int{

        val c = BiMemo<Int, Int, Int>{
            n : Int, i : Int ->
            when {
                i <= 0 && n > 0 -> 1
                n == 0 -> 1
                n < 0 -> 0
                else -> invoke(n, i - 1) + invoke(n - denominations[i], i)
            }
        }

        return c(n, denominations.size - 1)
    }

    println( coinSums(200, listOf(1,2,5,10,20,50,100,200)) )
}

