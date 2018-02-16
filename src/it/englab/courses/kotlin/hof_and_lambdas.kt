package it.englab.courses.kotlin

fun main(args: Array<String>) {

    println("is more than five chars? ${isMoreThanFive("short")}")
    println("is more than three chars? ${isMoreThanThree("loooong!", 42)}")

    wrap(::printBlock)

    val result = wrap {
        mathBlock(4)
    }
    println("Risultato $result")

}

val isMoreThanFive: (String) -> Boolean = {
    it.length > 5
}

typealias Predicate = (String, Int) -> Boolean
val isMoreThanThree: Predicate = { value, _ ->
    value.length > 3
}

fun printBlock() = println("Test Block!")
fun mathBlock(counter: Int) = counter + 1

fun <T> wrap(body: () -> T): T {
    try {
        println("Prima dell'esecuzione...")
        return body()
    } finally {
        println("Funzione eseguita correttamente")
    }
}
