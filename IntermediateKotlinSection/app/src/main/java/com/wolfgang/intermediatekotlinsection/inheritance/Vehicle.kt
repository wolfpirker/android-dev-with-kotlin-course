package com.wolfgang.intermediatekotlinsection.inheritance

open class Vehicle(
        val speed: Int = 40,
        val wheels: Int = 4,
        val doors: Int = 4,
        val driverName: String = "Wolfgang"
) {

    fun move() = speed * 5
    fun stop() = 0
    fun speedUp() = speed * 10
}