package com.wolfgang.intermediatekotlinsection

fun main(){

    println("I am inside Main function")

    myFirstSimpleFunction()
    mySecondSimpleFunction()

    val day = dayOfWeek()
    println("my favorite day of week is : $day")

    val number1 = 30
    val number2 = 12
    val result = sum(number1, number2)
    println("the result of $number1 + $number2 : $result")
}

fun myFirstSimpleFunction(){
    println("I am inside myFirstSimpleFunction")
}

fun mySecondSimpleFunction(){

    for(i in 1..10){
        println("number = $i")
    }
}

fun dayOfWeek() : String{

    val arrayOfDays = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

    return arrayOfDays[(0..6).random()]
}

fun sum(number1 : Int, number2 : Int) = number1 + number2