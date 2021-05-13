package com.wolfgang.intermediatekotlinsection.nestedclass

class Outer {

    var a : Int = 10

    inner class Nested{

        fun nestedFunction(){
            println("I am inside Nested Class $a")
        }
    }
}