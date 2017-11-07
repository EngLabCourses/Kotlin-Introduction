package it.englab.courses.kotlin

import it.englab.courses.kotlin.data.User

fun main(args: Array<String>) {
    val value = "value"

    println("E' uguale a 'value'? ${value.isEqualToValue()} [$value]")

    val user = User("Francesco", 29)
    user.isAuthenticated()
}

fun String?.isEqualToValue() : Boolean {
    return this.equals("value")
}

fun User.isAuthenticated() : Boolean {
    return true
}