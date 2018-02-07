package it.englab.courses.kotlin

fun main(args: Array<String>) {

    println(exampleIfAsExpression(false))

    exampleSmartCast("Esempio di Smart Cast")
    exampleSmartCast(29)

    exampleWithWhen(3)
    exampleWithWhen(27)
    exampleWithWhen(3.4)

    exampleWithMatching("Esempio di Matching con When")
    exampleWithMatching(39)
    exampleWithMatching(null)

    exampleWithFor()
    exampleWithForAdvanced()
}

fun exampleIfAsExpression(condition: Boolean): String {
    return if (condition) "true as String" else "false as String"
}

fun exampleSmartCast(obj: Any) {
    if (obj is String) {
        println("Value is $obj and length is ${obj.length}")
    } else {
        println("Obj is not a String")
    }
}

fun exampleWithWhen(x: Any) {
    val y = when (x) { 0 -> "is zero"
        1 -> "is one"
        2, 3 -> "two or three"
        in 0..100 -> "between 0 and 100"
        is Int -> "is Int"
        is Double -> "is Double"
        else -> "else block"
    }

    println("value of y is $y")
}

fun exampleWithMatching(obj: Any?) {
    when (obj) {
        is String -> println("Value is $obj and length is ${obj.length}")
        is Int -> println("Value is $obj")
        else -> println("Obj is not a String")
    }
}

fun exampleWithFor() {
    for ((i, c) in "engLab".withIndex()) {
        println("$i: $c")
    }
}

fun exampleWithForAdvanced() {
    (0 until "engLab".length).forEachIndexed {
        index, value -> println("$index: " + "engLab"[value])
    }
}