package main

import java.math.BigInteger
import kotlin.math.*
import java.lang.Math.*


fun <T> List<T>.head() = first()
fun <T> List<T>.tail() = if(count() == 1) listOf() else slice(1..lastIndex)

fun Int.abs(): Int = Math.abs(this)
fun Long.abs(): Long = Math.abs(this)

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

fun Int.toDigitsList() = this.toString().map { it.toString().toInt() }
fun Long.toDigitsList() = this.toString().map { it.toString().toLong() }

fun Int.length() = if(this == 0) 1 else ceil(log10(this + 1.0)).toInt()
fun Long.length() = if(this == 0L) 1 else ceil(log10(this + 1.0)).toInt()

fun dividesBy(n: Int) = { x: Int -> x.dividesBy(n) }
fun dividesBy(n: Long) = { x: Long -> x.dividesBy(n) }

fun bigInt(n: Int) = BigInteger(n.toString())

class Memo<T, R>(val f: ((T) -> R).(T) -> R) : (T) -> R {

    private val cache: MutableMap<T, R> = hashMapOf()

    override fun invoke(t: T): R {
        return cache.getOrPut(t, { f(t) })
    }

}

class BiMemo<T, U, R>(val f: ((T, U) -> R).(T, U) -> R) : (T, U) -> R {

    private val memo =
            Memo<Pair<T, U>, R> { p -> f(p.first, p.second) }

    override fun invoke(t: T, u: U): R = memo.invoke(Pair(t, u))

}


/* -----------------Math functions----------------- */

fun primeFactors(n: Long): List<Long> {
    val prime = (2..Math.sqrt(n.toDouble()).toInt()).find { n % it == 0.toLong() }
    return if (prime == null) listOf(n) else listOf(prime.toLong()) + primeFactors(n / prime)
}

fun factorial(n: Int): BigInteger =
        (n downTo 2).fold(BigInteger.ONE) { x, y -> x * bigInt(y) }

fun esieve(n: Int): List<Boolean> {
    val isPrime = Array(n, {true})
    isPrime[0] = false
    isPrime[1] = false
    (2..sqrt(n.toDouble()).toInt()).forEach { i ->
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
    else -> (2..sqrt(n.toDouble()).toInt())
            .filter { n.dividesBy(it) }
            .map {
                val div = n / it
                if (div != it ) it + div else it
            }
            .sum()
            .plus(1)
}

fun Long.isPandigital() : Boolean{
    fun isPandigital(num: Long, digits: Long): Boolean {
        if (num > 0) {
            val tmp = digits.or(1L.shl(num.toInt() % 10 - 1))
            if ( tmp == digits) {
                return false
            } else {
                return isPandigital(num / 10, tmp)
            }
        } else {
            return digits == 1L.shl( length() ) - 1
        }
    }
    return isPandigital(this, 0)
}

fun Long.isPrime() = when{
    this == 1L -> false
    this == 2L -> true
    this.dividesBy(2) -> false
    else -> (3..sqrt(this.toDouble()).toLong()).step(2).none { this % it == 0L }
}

fun Int.isPrime() = this.toLong().isPrime()

fun gcf(a: Int, b: Int):Int = if(b==0) a else  gcf(b, a % b )

fun lcm(a:Int, b:Int):Int =  a / gcf(a, b) * b;

fun Int.isPandigital() = this.toLong().isPandigital()

infix fun Int.concat(b : Int) = this * 10.pow(b.length()) + b
infix fun Long.concat(b : Long) = this * 10.pow(b.length()) + b

fun Int.reverse(b: Int = 10, rev: Int = 0): Int = if (this > 0) (this / b ).reverse(b, rev * b + this % b) else rev
fun Int.isPalindrome(b:Int = 10) = this == this.reverse(b)