package it.englab.courses.kotlin

fun main(args: Array<String>) {

    val nullableValue: String? = getStringValue()

    println("String length ${nullableValue!!.length}")
    println("Elvis operator length ${getLength(nullableValue)}")

    val s = "stringa"
    val number: Int? = s as? Int
    println("number is $number")

}

private fun getStringValue(): String = "Could be null!"

private fun getLength(value: String?) = value?.length ?: 0
