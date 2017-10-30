package it.englab.courses.kotlin.data

data class User(val name: String, val age: Int, var sex: Char = 'M')

fun main(args: Array<String>) {
    val user = User("Francesca", 27)
    user.sex = 'F'
    println("User $user")

    val clone = user.copy(name = "Francesco", sex = 'M')
    println("New user $clone")

    val (theName, theAge) = clone
    println("name: $theName")
    println("age : $theAge")
}
