package main

import java.math.BigInteger

/**
 * Power digit sum
 * https://projecteuler.net/problem=16
 */

fun main(args: Array<String>) {

    println(BigInteger("2").pow(1000).toString().map { it.toString().toInt() }.sum())

}
