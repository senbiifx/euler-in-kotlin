package main

/**
 * Double-base palindromes
 * https://projecteuler.net/problem=36
 */

fun main(args: Array<String>) {
    val palindromes = (1..999999).step(2)
                                 .filter { it.isPalindrome(10) }
                                 .filter { it.isPalindrome(2) }
    println(palindromes.sum())
    /*
    More optimization can be done by simply concatenating integers, i.e
    1 -> 11
    123 -> 123321
     */
}