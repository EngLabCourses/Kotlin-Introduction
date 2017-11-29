package it.englab.courses.kotlin

class OuterStaticExample {
    private val bar: Int = 1

    class Nested {
        fun foo() = 2
    }

}

class OuterNonStaticExample {
    private val bar = 1

    inner class Nested {
        fun foo() = bar
    }
}

fun main(args: Array<String>) {
    println("Nested static example: ${OuterStaticExample.Nested().foo()}")
    println("Nested non-static example: ${OuterNonStaticExample().Nested().foo()}")
}
