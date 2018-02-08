package it.englab.courses.kotlin

fun main(args: Array<String>) {

    println("is more than five chars? ${isMoreThanFive("short")}")
    println("is more than three chars? ${isMoreThanThree("loooong!", 42)}")

    wrap(::printBlock)
    println("Risultato ${wrap {
        mathBlock(4)
    }}")
}

val isMoreThanFive : (String) -> Boolean = {
    it.length > 5
}

val isMoreThanThree : (String, Int) -> Boolean = {
    value, _ -> value.length > 3
}

fun mathBlock(counter: Int) = counter + 1
fun printBlock() = println("Test Block!")

fun <T> wrap(body: () -> T): T {
    try {
        println("Prima dell'esecuzione...")
        return body()
    } finally {
        println("Funzione eseguita correttamente")
    }
}
