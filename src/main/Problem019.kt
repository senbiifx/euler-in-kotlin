package main

import java.time.DayOfWeek.*
import java.time.Month
import java.time.YearMonth

/**
 * Counting Sundays
 * https://main.net/problem=19
 */

fun main(args: Array<String>) {

    val r = (1901..2000)
                .asSequence()
                .flatMap { y -> Month.values().asSequence().map { m -> YearMonth.of( y, m ) } }
                .filter { it.atDay(1).getDayOfWeek().equals(SUNDAY) }
                .count()

    println(r)

}
