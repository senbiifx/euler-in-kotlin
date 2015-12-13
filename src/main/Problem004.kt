package main

/**
 * 	Largest palindrome product
 * https://main.net/problem=5
 */

fun main(args: Array<String>) {
        val largest = (100..999).asSequence()
                                .flatMap { i -> (100..999).asSequence().map { i * it  } }
                                .filter { it.toString().equals( it.toString().reversed() ) }
                                .max()
        println(largest)
}