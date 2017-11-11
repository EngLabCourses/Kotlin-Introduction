package it.englab.courses.kotlin

fun main(args : Array<String>){

    exampleSmartCast("Esempio di Smart Cast")
    exampleSmartCast(29)

}

fun exampleSmartCast(obj : Any){

    if(obj is String){
        println("Value is $obj and lenght is ${obj.length}")
    }else{
        println("Obj is not a String")
    }

}

