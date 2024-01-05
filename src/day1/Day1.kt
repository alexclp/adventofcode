package day1

import java.io.File

var input: List<String> = emptyList()

fun read() {
    File("src/day1/input.txt").forEachLine { input += it }
}

fun solve() {
    input = input.map { it.replace("[^0-9]".toRegex(), "") }
    var sum = 0
    input.forEach {
        sum = if (it.length > 1) sum + (it[0].digitToInt() * 10 + it[it.length-1].digitToInt()) else sum + (it.toInt() * 10 + it.toInt())
    }
    println(sum)
}

fun main() {
    read()
    solve()
}