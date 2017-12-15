package it.englab.courses.kotlin

fun main(args: Array<String>) {
    wrap(::printBlock)
    println("Risultato ${wrap {
        mathBlock(4)
    }}")
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
