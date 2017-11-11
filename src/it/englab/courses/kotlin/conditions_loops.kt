package it.englab.courses.kotlin

fun main(args: Array<String>) {
    exampleSmartCast("Esempio di Smart Cast")
    exampleSmartCast(29)

    exampleWithMatching("Esempio di Matching con When")
    exampleWithMatching(39)
    exampleWithMatching(null)
}

fun exampleSmartCast(obj: Any) {
    if (obj is String) {
        println("Value is $obj and lenght is ${obj.length}")
    } else {
        println("Obj is not a String")
    }
}

fun exampleWithMatching(obj: Any?) {
    when (obj) {
        is String -> println("Value is $obj and lenght is ${obj.length}")
        is Int -> println("Value is $obj")
        else -> println("Obj is not a String")
    }
}