package main

/**
 * Smallest multiple
 * https://main.net/problem=5
 */

fun main(args: Array<String>) {
    fun gcf(a: Int, b: Int):Int = if(b==0) a else  gcf(b, a % b )
    fun lcm(a:Int, b:Int):Int =  a / gcf(a, b) * b;

    val r = (1..20).reduce{x, y -> lcm(x, y)}

    println(r)
}
