package com.wolfgang.intermediatekotlinsection.visibilitymodifiers

open class B {

    fun accessClassAFromB(){

        val instanceA = A()
        println("property class A is : ${instanceA.propertyA}")
        instanceA.functionA()
    }
}