package it.englab.courses.kotlin

class Empty : Any()

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

object Manager {
    fun registerItem(item: String) {}
    val items: Array<String> = arrayOf("item1", "item2")
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
}
