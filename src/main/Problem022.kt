package main

import java.io.File

/**
 *  Names scores
 *  https://projecteuler.net/problem=22
 */

fun main(args: Array<String>) {

    val words = File("src/resources/Problem022.txt").readText().split(',')

    val total = words.sorted()
                     .mapIndexed { index, string ->
                         string.toList()
                               .map(Char::toInt)
                               .filterNot( equals(34) )
                               .map( minus(64) )
                               .sum()
                               .times(index + 1)
                     }
                     .sum()

    println(total)

}
