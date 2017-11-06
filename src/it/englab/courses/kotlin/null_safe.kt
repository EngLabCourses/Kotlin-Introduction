package it.englab.courses.kotlin

fun main(args: Array<String>) {

    val nullableValue: String? = getStringValue()

    println("String length ${nullableValue!!.length}")
    println("Elvis operator length ${getLength(nullableValue)}")
}


private fun getStringValue() : String {
    return "Could be null!"
}

private fun getLength(value : String?) : Int {
    return value?.length ?: 0
}