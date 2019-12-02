package day2

import loadFileByLine

private enum class Instruction(private val code: Int) {
    ADD(1),
    MULTIPLY(2),
    END(99);

    companion object {
        fun forCode(code: Int) = values().firstOrNull { it.code == code } ?: error("Illegal op code $code")
    }
}

fun main() {
    val ints = loadFileByLine("day2.txt").joinToString()
        .split(',')
        .map { it.toInt() }

    part1(ints)
    part2(ints)
}

private fun executeInstructions(ints: List<Int>): List<Int> {
    val mInts = ints.toMutableList()
    loop@ for (ip in 0..mInts.size step 4) {
        when (Instruction.forCode(mInts[ip])) {
            Instruction.ADD -> mInts[mInts[ip + 3]] = mInts[mInts[ip + 1]] + mInts[mInts[ip + 2]]
            Instruction.MULTIPLY -> mInts[mInts[ip + 3]] = mInts[mInts[ip + 1]] * mInts[mInts[ip + 2]]
            Instruction.END -> break@loop
        }
    }
    return mInts
}

private fun part1(ints: List<Int>) {
    val mInts = ints.toMutableList()
    mInts[1] = 12
    mInts[2] = 2

    val result = executeInstructions(mInts)

    println(result[0])
}

fun part2(ints: List<Int>) {
    for (noun in 0..99)
        for (verb in 0..99) {
            var currentInts = ints.toMutableList()
            currentInts[1] = noun
            currentInts[2] = verb
            currentInts = executeInstructions(currentInts).toMutableList()
            if (currentInts[0] == 19690720) {
                println(100 * noun + verb)
                break
            }
        }
}
