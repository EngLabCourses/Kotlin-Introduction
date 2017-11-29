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

## Esempio di *class*, *object*, *interface*, *enum*, *singleton* e *companion objects*

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
    fun registerItem(item: String) {}
    val items: Array<String> = arrayOf("item1", "item2")
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

fun main(args: Array<String>) {
    Empty()
    Derived()
    DifferentDerived()

    val contract: Contract = ContractImpl()
    contract.method1()

    Person("Francesco")
    Person("Francesco", "D'Amico")

    Manager.registerItem("item")
    Manager.items

    println("enum name ${ProtocolState.TALKING.name}")
    println("enum ordinal ${ProtocolState.TALKING.ordinal}")

    val state = ProtocolState.WAITING
    println("current state -> $state")
    println("new state     -> ${state.signal()}")
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

## Esempio di `?.` (*Safe Call Operator*) e di `?:` (*Elvis Operator*)

```kotlin
fun main(args: Array<String>) {

    val nullableValue: String? = getStringValue()

    println("String length ${nullableValue!!.length}")
    println("Elvis operator length ${getLength(nullableValue)}")
}

private fun getStringValue() : String = "Could be null!"

private fun getLength(value : String?) = value?.length ?: 0
```

## Esempio di *Extension functions* e *Funzioni fuori dalle classi*

```kotlin
fun main(args: Array<String>) {
    val value = "value"

    println("E' uguale a 'value'? ${value.isEqualToValue()} [$value]")

    val user = User("Francesco", 29)
    user.isAuthenticated()

    utilityMethod()
}

fun String?.isEqualToValue() : Boolean {
    return this.equals("value")
}

fun User.isAuthenticated() : Boolean {
    return true
}
```

## Esempio di *Smart Cast* e uso del *when*

```kotlin
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
```
