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
    
## Definizione variabili, *type inference* e *null check*

```kotlin
    val value : String = "world"
    val anotherValue : String? = null
    println("Hello...$value!")
```

## Esempio di *data class* e differenza con JAVA (Mostrare il set di una property e il valore di default come sostituzione del pattern *Builder*)

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

## Esempio di estensione classe e override dei metodi (con valori di default) - Differenza con Java




