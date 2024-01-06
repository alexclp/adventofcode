package day1

import java.io.File

var input: MutableList<String> = emptyList<String>().toMutableList()

fun read() {
    File("src/day1/input.txt").forEachLine { input += it }
}

fun solve() {
    val modifiedList = input.map { it.replace("[^0-9]".toRegex(), "") }
    var sum = 0
    modifiedList.forEach {
        sum = if (it.length > 1) sum + (it[0].digitToInt() * 10 + it[it.length-1].digitToInt()) else sum + (it.toInt() * 10 + it.toInt())
    }
    println(sum)
}

fun main() {
    read()
    solve()
}