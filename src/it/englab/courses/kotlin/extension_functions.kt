package it.englab.courses.kotlin

fun main(args: Array<String>) {
    val value = "value"

    println("E' uguale a 'value'? ${value.isEqualToValue()} [$value]")
}

fun String?.isEqualToValue() : Boolean {
    return this.equals("value")
}
