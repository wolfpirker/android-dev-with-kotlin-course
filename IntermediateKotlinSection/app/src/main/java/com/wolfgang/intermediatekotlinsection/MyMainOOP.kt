package com.wolfgang.intermediatekotlinsection

fun main(){

    val car1 = Car(40, 6, 5)
    println("car1 speed is: ${car1.speed}, gear is ${car1.gear}, seats: ${car1.seat}")

    println("car1 speed after speeding up is: ${car1.speedUp()}")

    val car2 = Car(5, 50, 5, 4)

    println("the distance cross by speed ${car2.speed} willbe ${car2.distance}")
}