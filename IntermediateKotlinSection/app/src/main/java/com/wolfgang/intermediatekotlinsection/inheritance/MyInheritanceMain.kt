package com.wolfgang.intermediatekotlinsection.inheritance

fun main(){
    val car = Car(4)

    println("some inherited properties will be doors: ${car.doors} and speed :${car.speed}")
    println("some inherited methods will be move: ${car.move()} and stop : ${car.stop()}")

    val truck = Truck(1000)

    println("some inherited properties will be doors: ${truck.doors} and speed :${truck.speed}")
    println("some inherited methods will be move: ${truck.move()} and speedUp :${truck.speedUp()}")
}