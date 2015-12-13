package main

import java.io.File

/**
 *  Names scores
 *  https://main.net/problem=22
 */
fun main(args: Array<String>) {

    val words = File("src/resources/Problem022.txt").readText().split(',')

    val total = words.sorted()
                     .mapIndexed { index, string ->
                         string.toList()
                               .map { it.toInt() }
                               .filterNot { it == 34 }
                               .map { it - 64 }
                               .sum()
                               .times(index + 1)
                     }
                     .sum()

    println(total)
}
