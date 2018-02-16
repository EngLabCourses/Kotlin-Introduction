package it.englab.courses.kotlin.data

data class User(val name: String, val age: Int, var sex: Char = 'M', var job : String = "impiegato")

fun main(args: Array<String>) {
    val user = User("Francesca", 27)
    user.sex = 'F'
    println("User $user")

    //si consiglia di inizializzare gli oggetti sempre con il metodo .apply()
    val newUser = User("Matteo", 30).apply {
        sex = 'M'
        job = "student"
    }
    println("New User $newUser")

    val clone = user.copy(name = "Francesco", sex = 'M')
    println("New user $clone")

    val (theName, theAge) = clone
    println("name: $theName")
    println("age : $theAge")

}
