package it.englab.courses.kotlin

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
 *
 * esempio alternativo di sealed class -> https://proandroiddev.com/kotlin-sealed-classes-enums-with-swag-d3c4b799bcd4
 */
sealed class Response

data class Success(val body : String) : Response()

data class Error(val code : Int, val description : String) : Response()

object Timeout : Response() //singleton non contenendo dati!

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