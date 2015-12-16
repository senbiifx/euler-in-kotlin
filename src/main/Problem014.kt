package main

/**
 * Longest Collatz sequence
 * https://main.net/problem=14
 */

fun main(args: Array<String>) {

    tailrec fun collatz(i:Long, acc:Long):Long{
        return if(i == 1.toLong())
                    acc + 1
               else
                    collatz (
                        if( i.dividesBy(2) ) i / 2 else 3 * i + 1,
                        acc + 1
                    )
    }

    fun maxChain(n:Int):Long?{
        return (1..n).map { collatz(it.toLong(), 0) }.max()
    }

    println( maxChain(1000000) )

}
