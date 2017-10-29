package it.englab.courses.kotlin.data

data class User(val name: String, val age: Int, var sex : Char = 'M')

fun main(args: Array<String>) {
    val user = User("Francesco", 27)
    user.sex = 'F'
    println("User $user")
}