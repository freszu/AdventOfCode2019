package day1

object FuelCalc{
    fun calculateRequiredFuel(mass: Int) = Math.floorDiv(mass, 3) - 2
}
