package it.englab.courses.kotlin.builder

fun main(args: Array<String>) {
    orderHamburger(cheese = true, bacon = true, bread = true)

    val myPizzaMargherita = Pizza(
            size = 30,
            mozzarella = true,
            tomato = true)
    println("$myPizzaMargherita")

    val myPizzaJava = PizzaJava.Builder(30)
            .mozzarella(true)
            .tomato(true)
            .build()
    println("$myPizzaJava")
}

fun orderHamburger(ham: Boolean = false,
                   cheese: Boolean = false,
                   salad: Boolean = false,
                   tomato: Boolean = false,
                   bacon: Boolean = false,
                   bread: Boolean = false,
                   ketchup: Boolean = false) {
}

data class Pizza(val size: Int,
                 val tomato: Boolean = false,
                 val mozzarella: Boolean = false,
                 val ham: Boolean = false,
                 val sausage: Boolean = false,
                 val mushrooms: Boolean = false,
                 val pineapple: Boolean = false)
