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
    
## Definizione variabili e *type inference*

```kotlin
fun main(args: Array<String>) {
    val value = true
    println("Hello...$value!")
}
```

## Esempio di *class*, *object*, *interface*, *enum*, *sealed*, *singleton* e *companion objects*

```kotlin
class Empty : Any()

//In Java sono open di default mentre in Kotlin di default sono final
open class Base {
    open fun overridableMethod() {}
    fun notOverridableMethod() {}
}

class Derived : Base() {
    override fun overridableMethod() {
        super.overridableMethod()
        println("method override!")
    }
}

open class DifferentDerived : Base() {
    final override fun overridableMethod() {
        super.overridableMethod()
        println("another method override!")
    }
}

interface Contract {
    fun method1()
    fun method2(){
        println("method2")
    }
}

class ContractImpl : Contract {
    override fun method1() {}
}

class Person constructor(name: String) {

    init {
        println("Class initialized with name ${name.toUpperCase()}")
    }

    constructor(name: String, surname: String) : this(name) {
        println("Class initialized with name $name and surname $surname")
    }
}

//Equivalente di un Singleton in Java
object Manager {
    fun registerItem(item: String) {
        items.add(item)
    }
    val items: MutableList<String> = mutableListOf("item1", "item2")
}

enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}

/**
 * Esempio d'uso di una classe "sealed" in sostituzione degli Enum
 */
sealed class Response

data class Success(val body : String) : Response()

data class Error(val code : Int, val description : String) : Response()

object Timeout : Response()

fun main(args: Array<String>) {
    Empty()
    Derived()
    DifferentDerived()

    val contract: Contract = ContractImpl()
    contract.method1()

    Person("Francesco")
    Person("Francesco", "D'Amico")

    println("Items in list ${Manager.items.size}")
    Manager.registerItem("item")
    println("Items in list ${Manager.items.size}")
    Manager.registerItem("new item")
    println("Items in list ${Manager.items.size}")

    println("enum name ${ProtocolState.TALKING.name}")
    println("enum ordinal ${ProtocolState.TALKING.ordinal}")

    val state = ProtocolState.WAITING
    println("current state -> $state")
    println("new state     -> ${state.signal()}")

    analyzeResponse(Error(404, "not found"))
}

fun analyzeResponse(response : Response) {
    when(response){
        is Success -> println(response.body)
        is Error -> println("${response.code} : ${response.description}")
        is Timeout -> println("Timeout!")
    }
}
```

##Esempio di *Inner class* e differenza tra `static` e `non-static`

```kotlin
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
```

## Esempio di *data class* e inizializzazione con il metodo *apply()*

```kotlin
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
}
```

## Esempio del metodo `copy()`

```kotlin
data class User(val name: String, val age: Int, var sex: Char = 'M', var job : String = "impiegato")

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
data class User(val name: String, val age: Int, var sex: Char = 'M', var job : String = "impiegato")

fun main(args: Array<String>) {
    val user = User("Francesca", 27)
    user.sex = 'F'
    println("User $user")

    val clone = user.copy(name = "Francesco", sex = 'M')
    println("New user $clone")

    //si consiglia di inizializzare gli oggetti sempre con il metodo .apply()
    val newUser = User("Matteo", 30).apply {
        sex = 'M'
        job = "student"
    }
    println("New User $newUser")

    val (theName, theAge) = clone
    println("name: $theName")
    println("age : $theAge")

}
```

## Esempio di *named e default parameters* (pattern *Builder* in Kotlin)

```kotlin
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

```

## Esempio di `as?` (safe cast), `?.` (*Safe Call Operator*) e di `?:` (*Elvis Operator*)

```kotlin
fun main(args: Array<String>) {

    val nullableValue: String? = getStringValue()

    println("String length ${nullableValue!!.length}")
    println("Elvis operator length ${getLength(nullableValue)}")

    val s = "stringa"
    val number: Int? = s as? Int
    println("number is $number")

}

private fun getStringValue(): String = "Could be null!"

private fun getLength(value: String?) = value?.length ?: 0
```

## Esempio di *Extension functions* e *Funzioni fuori dalle classi*

```kotlin
fun main(args: Array<String>) {
    val value = "value"

    println("E' uguale a 'value'? ${value.isEqualToValue()} [$value]")

    println("pow result ${2.pow()}")

    utilityMethod()
}

fun String?.isEqualToValue(): Boolean {
    return equals("value")
}

fun Int.pow(): Int {
    return this * this
}
```

## Esempio di *Condition statements*, *Loops*, *Smart Cast* e uso del *when*

```kotlin
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
```

## Esempio di *Function type*, *High Order Functions* and *Lambda expressions* con uso del *typealias*

```kotlin
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
```
