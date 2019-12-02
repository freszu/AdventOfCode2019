package day1

import day1.FuelCalc.calculateRequiredFuel
import loadFileByLine

fun main() {
    val result = loadFileByLine("day1.txt")
        .map { it.toInt() }
        .map(::calculateRequiredFuel)
        .flatMap { requiredFuel ->
            val additionalFuelCollect = mutableListOf(requiredFuel)
            var additionalFuel = calculateRequiredFuel(requiredFuel)
            while (additionalFuel > 0) {
                additionalFuelCollect.add(additionalFuel)
                additionalFuel = calculateRequiredFuel(additionalFuel)
            }
            additionalFuelCollect
        }
        .sum()

    println("Result: $result")
}

