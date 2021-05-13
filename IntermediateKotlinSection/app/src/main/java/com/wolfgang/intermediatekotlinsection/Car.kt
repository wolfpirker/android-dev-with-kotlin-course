package com.wolfgang.intermediatekotlinsection

class Car(val speed : Int, val gear : Int, val seat : Int) {

    var distance : Int = 0
    fun speedUp()= speed*4

    constructor(time : Int,  speed: Int, gear: Int, seat: Int) : this(speed, gear, seat){
        distance = speed * time
    }
}