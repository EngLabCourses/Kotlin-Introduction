package it.englab.courses.kotlin

fun main(args: Array<String>) {
    val value = "value"

    println("E' uguale a 'value'? ${value.isEqualToValue()} [$value]")

    println("pow result ${2.pow()}")

    utilityMethod()
}

fun String?.isEqualToValue(): Boolean {
    return equals("value")
}

fun Int.pow(): Int {
    return this * this
}
