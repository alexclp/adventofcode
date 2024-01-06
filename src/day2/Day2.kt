package day2

import java.io.File

fun main() {
    val allowedValues = mapOf(
            "red" to 12,
            "green" to 13,
            "blue" to 14
            )

    var counter = 0
    var possible = true
    var sum = 0
    var powerSum = 0

    File("src/day2/input.txt").forEachLine { line ->
        counter += 1
        val groupMinimums = mutableMapOf(
                "red" to 0,
                "green" to 0,
                "blue" to 0
        )

        val groups = "(\\d+) (\\w+)".toRegex().findAll(line, 0)
        groups.forEach { group ->
            val value = group.groupValues[1].toInt()
            val colour = group.groupValues[2]

            if (value > allowedValues[colour]!!) {
                possible = false
            }

            if (value > groupMinimums[colour]!!) {
                groupMinimums[colour] = value
            }
        }
        if (possible) {
            sum += counter
        }
        possible = true

        powerSum += groupMinimums["red"]!! * groupMinimums["green"]!! * groupMinimums["blue"]!!
    }
    println(sum)
    println(powerSum)
}