package main

/**
 * Sum square difference
 * https://main.net/problem=6
 */


fun main(args: Array<String>) {

    fun squareOfSum(n :Int):Int =
            (n * ( n + 1) / 2).pow( 2 )

    fun sumOfSquares(n:Int):Int = n * ( n + 1 ) * ( 2 * n + 1 ) / 6

    println ( squareOfSum(100) - sumOfSquares(100)  )
}
