package day1

import day1.FuelCalc.calculateRequiredFuel
import loadFileByLine

fun main() {
    val result = loadFileByLine("day1.txt")
        .map { it.toInt() }
        .map(::calculateRequiredFuel)
        .sum()

    println("Result: $result")
}
