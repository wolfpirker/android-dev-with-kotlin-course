package com.wolfgang.intermediatekotlinsection.visibilitymodifiers

class C : A() {

    fun accessClassA(){
        val instanceA = A()
        println("property class A is : ${propertyA}")
        functionA()
    }
}