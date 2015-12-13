package main

import java.math.BigInteger
import kotlin.math.*

/**
 * Lattice paths
 * https://main.net/problem=15
 */
fun main(args: Array<String>) {
    //solution: nCr, where n = 40, r = 20

    fun combination(n: Int, r: Int): BigInteger =
            factorial(n) / ( factorial(n - r) * factorial(r) )

    fun countRoutes(d: Int): Long = combination(d * 2, d).toLong()

    println(countRoutes(20))

}
