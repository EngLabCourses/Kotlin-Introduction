# Kotlin-Introduction
Introduzione a Kotlin per EngLab

## Hello World!

```kotlin
    fun main(args: Array<String>) {
       println("Hello, world!")
    }
```

## Hello World evoluto con *String template*

```kotlin
    fun main(args: Array<String>) {
       val scope = "world"
       println("Hello, $scope!")
    }
```
    
## Definizione variabili, *type inference*

```kotlin
package it.englab.courses.kotlin

fun main(args: Array<String>) {
    val value = true
    println("Hello...$value!")
}
```

## Esempio di *data class*

```kotlin
    data class User(val name: String, val age: Int, var sex : Char = 'M' )

    fun main(args: Array<String>) {
        val user = User("Francesca", 29)
        user.sex = 'F'
        println("User $user")
    }
```

## Esempio del metodo `copy()`

```kotlin
    fun main(args: Array<String>) {
        val user = User("Francesca", 27)
        user.sex = 'F'
        println("User $user")

        val clone = user.copy(name = "Francesco", sex = 'M')
        println("New user $clone")
    }
```

## Uso dei metodi `componentN()`

```kotlin
    fun main(args: Array<String>) {
        val user = User("Francesca", 27)
        user.sex = 'F'
        println("User $user")

        val clone = user.copy(name = "Francesco", sex = 'M')
        println("New user $clone")

        //esempio - clone.component1()

        val (theName, theAge) = clone
        println("name: $theName")
        println("age : $theAge")
    }
```

## Esempio di *named e default parameters* (pattern *Builder* in Kotlin)

```kotlin
package it.englab.courses.kotlin

fun main(args: Array<String>) {
    orderHamburger(cheese = true, bacon = true, bread = true)
    val myPizzaMargherita = Pizza(mozzarella = true, tomato = true)
}

fun orderHamburger(ham: Boolean = false,
                   cheese: Boolean = false,
                   salad: Boolean = false,
                   tomato: Boolean = false,
                   bacon: Boolean = false,
                   bread: Boolean = false,
                   ketchup: Boolean = false) {
}

data class Pizza(val tomato: Boolean = false,
                 val mozzarella: Boolean = false,
                 val ham: Boolean = false,
                 val sausage: Boolean = false,
                 val mushrooms : Boolean = true,
                 val pineapple: Boolean = false)
```

## Esempio di Null Safety e di `?:` (Elvis Operator)

```kotlin
package it.englab.courses.kotlin

fun main(args: Array<String>) {

    val nullableValue: String? = getStringValue()

    println("String length ${nullableValue!!.length}")
    println("Elvis operator length ${getLength(nullableValue)}")
}


private fun getStringValue() : String {
    return "Could be null!"
}

private fun getLength(value : String?) : Int {
    return value?.length ?: 0
}
```

## Esempio di *Extension functions*

```kotlin
package it.englab.courses.kotlin

fun main(args: Array<String>) {
    val value = "value"

    println("E' uguale a 'value'? ${value.isEqualToValue()} [$value]")
}

fun String?.isEqualToValue() : Boolean {
    return this.equals("value")
}
```
