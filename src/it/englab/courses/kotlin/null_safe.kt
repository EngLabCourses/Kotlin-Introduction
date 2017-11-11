package it.englab.courses.kotlin

fun main(args: Array<String>) {

    val nullableValue: String? = getStringValue()

    println("String length ${nullableValue!!.length}")
    println("Elvis operator length ${getLength(nullableValue)}")
}

private fun getStringValue() : String = "Could be null!"

private fun getLength(value : String?) = value?.length ?: 0
