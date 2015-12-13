package main

import java.math.BigInteger
import kotlin.math.*

/**
 *  Common functions
 */

/*extensions*/
fun <T> List<T>.head() = first()
fun <T> List<T>.tail() = if(count() == 1) listOf() else slice(1..lastIndex)
fun Int.pow(n: Int): Int = Math.pow(this.toDouble(), n.toDouble()).toInt()
fun Long.pow(n: Long): Long = Math.pow(this.toDouble(), n.toDouble()).toLong()
fun Int.dividesBy(n: Int): Boolean = this % n == 0
fun Long.dividesBy(n: Long): Boolean = this % n == 0L
fun BigInteger.dividesBy(n: BigInteger): Boolean = this.mod(n) == BigInteger.ZERO
fun Iterable<Int>.product() = fold(1) { a, b: Int -> a * b }
fun Iterable<Long>.product() = fold(1.toLong()) { a, b: Long -> a * b }
fun Iterable<BigInteger>.product() = fold(bigInt(1)) { a, b: BigInteger -> a * b }
fun Sequence<Int>.product() = fold(1) { a, b -> a * b }
fun Sequence<Long>.product() = fold(1.toLong()) { a, b -> a * b }
fun Sequence<BigInteger>.product() = fold(bigInt(1)) { a, b -> a * b }


fun dividesBy(n: Int) = { x: Int -> x.dividesBy(n) }
fun dividesBy(n: Long) = { x: Long -> x.dividesBy(n) }


fun bigInt(n: Int) = BigInteger(n.toString())

fun primeFactors(n: Long): List<Long> {
    val prime = (2..Math.sqrt(n.toDouble()).toInt()).find { n % it == 0.toLong() }
    return if (prime == null) listOf(n) else listOf(prime.toLong()) + primeFactors(n / prime)
}

fun factorial(n: Int): BigInteger =
        (n downTo 2).fold(BigInteger.ONE) { x, y -> x * bigInt(y) }

fun sieve(n: Int): List<Boolean> {
    val isPrime: MutableList<Boolean> = sequence { true }.take(n).toArrayList()
    isPrime[0] = false
    isPrime[1] = false
    (2..Math.sqrt(n.toDouble()).toInt()).forEach { i ->
        if (isPrime[i]) {
            var j = i
            while (i * j < n) {
                isPrime[i * j++] = false
            }
        }
    }
    return isPrime.toList()
}

fun sumOfDivisors(n: Int): Int = when (n) {
    4 -> 3
    in 1..5 -> 1
    else -> (2..Math.sqrt(n.toDouble()).toInt())
            .filter { n.dividesBy(it) }
            .map {
                val div = n / it
                if (div != it ) it + div else it
            }
            .sum()
            .plus(1)
}


class Memoize<T, R>(val f: ((T) -> R).(T) -> R) : (T) -> R {
    private val cache: MutableMap<T, R> = hashMapOf()

    override fun invoke(t: T): R {
        return cache.getOrPut(t, { f(t) })
    }

}
